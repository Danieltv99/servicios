package com.co.torres.curso.repository;

import com.co.torres.curso.models.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
