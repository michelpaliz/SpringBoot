package com.testing.demo.Models;

import java.time.LocalDate;
import java.time.Period;

public class Estudiante {
    private long id;
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;
    private Integer edad;

    // En este constructo no utlizo el id; lo va a generar mi base de datos
    public Estudiante(String nombre, String email, LocalDate fechaNacimiento, Integer edad) {
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    public Estudiante(long id, String nombre, String emai, LocalDate fechaNacimiento, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.email = emai;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return
     */
    public Integer calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student [edad=" + edad + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + ", id=" + id
                + ", nombre=" + nombre + "]";
    }

}
