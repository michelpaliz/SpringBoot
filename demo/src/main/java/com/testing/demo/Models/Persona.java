package com.testing.demo.Models;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String dni;
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;
    private Integer edad;

    // En este constructo no utlizo el id; lo va a generar mi base de datos
    public Persona(String dni, String nombre, String email, LocalDate fechaNacimiento, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = edad;
    }

    public String getId() {
        return dni;
    }

    public void setId(String dni) {
        this.dni = dni;
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
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                '}';
    }
}
