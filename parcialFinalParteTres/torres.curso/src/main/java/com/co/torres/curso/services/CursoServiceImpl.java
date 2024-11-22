package com.co.torres.curso.services;



import com.co.torres.SpringCommons.service.CommonService;
import com.co.torres.SpringCommons.service.CommonServiceImpl;



import com.co.torres.curso.models.entity.Curso;
import com.co.torres.curso.repository.CursoRepository;
import org.springframework.stereotype.Service;


@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CommonService<Curso> {
}
