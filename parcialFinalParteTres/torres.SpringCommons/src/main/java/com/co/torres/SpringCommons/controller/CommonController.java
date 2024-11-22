package com.co.torres.SpringCommons.controller;


import com.co.torres.SpringCommons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class CommonController <E, S extends CommonService<E>> {


    // AlumnoService se cambia por la letra S
    //Entidad Alumno se cambia por la letra E
    @Autowired
    protected S service;


    @Value("${config.balanaceador.test}")
    protected String balanceadorTest;



    @GetMapping("/balanceaor-test")
    protected ResponseEntity<?> balanceadorTest() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("balanceador", balanceadorTest);
        response.put("alumno", service.findAll());

        return ResponseEntity.ok().body(response);
    }


    @GetMapping("/listar")
    protected ResponseEntity<?> listarAlumno() {

        return ResponseEntity.ok().body(service.findAll());
    }


    @GetMapping("/")
    protected ResponseEntity<?> ver(@PathVariable Long id) {

        Optional<E> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ob.get());
    }

    @PostMapping
    protected ResponseEntity<?> crear(@RequestBody E entity) {

        E alumnoDb = service.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }



    @DeleteMapping("/{id}")
    protected ResponseEntity<?> eliminar(@PathVariable Long id) {

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
