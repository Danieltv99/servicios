package com.co.torres.usuarios.service;

import java.util.Optional;

import com.co.torres.usuarios.entity.Alumno;

public interface AlumnoService {

    public Iterable<Alumno> findAll ();

    public Optional<Alumno> findById (Long id);

    public Alumno save(Alumno alumno);

    public void deleteById (Long id);
}
