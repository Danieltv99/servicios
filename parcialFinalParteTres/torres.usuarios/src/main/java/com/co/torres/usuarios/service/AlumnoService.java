package com.co.torres.usuarios.service;


import com.co.torres.SpringCommons.service.CommonService;
import com.co.torres.usuarios.entity.Alumno;

public interface AlumnoService extends CommonService<Alumno> {

    public Alumno save(Alumno alumno);

    public void deleteById (Long id);
}
