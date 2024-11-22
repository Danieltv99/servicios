package com.co.torres.usuarios.repository;

import com.co.torres.usuarios.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

// La interfaz AlumnoRepository extiende CrudRepository, lo que permite la interacción con la base de datos.
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
    // Los métodos CRUD básicos (save, findById, findAll, deleteById) son proporcionados automáticamente
}
