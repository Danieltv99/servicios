package com.co.torres.usuarios.controller;


import com.co.torres.usuarios.entity.Alumno;
import com.co.torres.usuarios.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AlumnoController {

    @Autowired
    private AlumnoService service;

    // Método para listar todos los alumnos
    @GetMapping
    public ResponseEntity<?> listarAlumno() {

        return ResponseEntity.ok().body(service.findAll());
    }

    // Método para obtener un alumno por ID
    @GetMapping("/")
    public ResponseEntity<?> ver(@PathVariable Long id) {

        Optional<Alumno> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {

        Alumno alumnoDb = service.save(alumno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Alumno alumno,@PathVariable Long id) {

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

    @DeleteMapping("/{id}")
    private ResponseEntity<?> eliminar(@PathVariable Long id) {

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
