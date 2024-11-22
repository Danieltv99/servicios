package com.co.torres.common.usuario.models.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAT;

    @PrePersist
    private void prePersist() {
        this.createAT = new Date();
    }

    // Constructor por defecto
    public Alumno() {}

    // Constructor con todos los campos
    public Alumno(Long id, String nombre, String apellido, String email, Date createAT) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.createAT = createAT;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAT() {
        return createAT;
    }

    public void setCreateAT(Date createAT) {
        this.createAT = createAT;
    }

    // punto 13 apartado 5
    @Override
    public boolean equals(Object obj) {
        // SE VA A HACER UNA VALIDACION DENTRO DEL METOO
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Alumno)) {
            return false;
        }
        Alumno a = (Alumno) obj;
        return this.id != null && this.id.equals(a.getId());
        //TODO Auto-generate method stub
        //return super.equals(obj);
    }

    // Sobrescribir el método toString
    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", createAT=" + createAT +
                '}';
    }
}

