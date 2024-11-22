package com.co.torres.usuarios.service;


import com.co.torres.usuarios.entity.Alumno;
import com.co.torres.usuarios.repository.AlumnoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository dao;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll () {
        //TODO Auto-generated method stub
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id){
        //TODO Auto-generated method stub
        return dao.findById(id);
    }

    @Override
    @Transactional
    public Alumno save (Alumno alumno) {
        //TODO Auto-generated method stub
        return dao.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        dao.deleteById(id);
    }
}
