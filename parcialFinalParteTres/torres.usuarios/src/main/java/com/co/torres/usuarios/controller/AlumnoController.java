package com.co.torres.usuarios.controller;



import com.co.torres.SpringCommons.controller.CommonController;
import com.co.torres.common.usuario.models.entity.Alumno;
import com.co.torres.usuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

    @Autowired
    private AlumnoService service;


    // Se inyecta la variable de entorno en el controlador "AlumnoController" -> config.balanaceador.test=${BALANCEADOR_TEST: string por defecto}
    @Value("${config.balanaceador.test}")
    private String balanceadorTest;


    /* Se crea un metodo dentro del controlador, que retorne el valor de la variable de entorno  junto a la lista de
     alumnos dentro de un HasMap , de la siguiente forma:
     */
    @GetMapping("/balanceaor-test")
    public ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("alumno", service.findAll());

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable Long id) {

        Optional<Alumno> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        Alumno alumnoBd = ob.get();
        alumnoBd.setNombre(alumno.getNombre());
        alumnoBd.setApellido(alumno.getApellido());
        alumnoBd.setEmail(alumno.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(service);
    }
}
