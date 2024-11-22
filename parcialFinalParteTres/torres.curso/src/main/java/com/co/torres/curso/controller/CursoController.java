package com.co.torres.curso.controller;

import com.co.torres.SpringCommons.controller.CommonController;
import com.co.torres.curso.models.entity.Curso;
import com.co.torres.curso.services.CursoService;
import com.co.torres.common.usuario.models.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curso")
public class CursoController extends CommonController<Curso, CursoService> {

    @Autowired
    public CursoController(CursoService cursoService) {
        super();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {
        Optional<Curso> cursoExistente = service.findById(id);

        if (cursoExistente.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoActual = cursoExistente.get();
        cursoActual.setNombre(curso.getNombre());
        Curso cursoActualizado = service.save(cursoActual);
        return ResponseEntity.ok(cursoActualizado);
    }

    // METODO PARA ASIGNAR UN ALUMNO AL CURSO
    @PutMapping("/{id}/asignar-alumno")
    public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumno, @PathVariable Long id){

        Optional<Curso> ob = service.findById(id);

        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Curso cursoBd = ob.get();
        alumno.forEach(a -> {
            cursoBd.addAlumnos(a);
        });

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));

    }

    //METODO PARA ELIMINAR UN ALUMNO DEL CURSO
    @PutMapping("/{id}/eliminar-alumno")
    public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
        Optional<Curso> ob = service.findById(id);

        if (ob.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoBd = ob.get();
        cursoBd.removeAlumnos(alumno);
        service.save(cursoBd);
        return ResponseEntity.ok(cursoBd);
    }


}










