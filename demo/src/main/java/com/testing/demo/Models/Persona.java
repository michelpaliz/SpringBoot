package com.testing.demo.Models;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

// @Table(name = "empleados")
@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String dni;
    // @Column(name = "Nombre", nullable = false, length = 50)
    private String nombre;
    // @Column(name = "Email", nullable = false, length = 50)
    private String email;
    // @Column(name = "FechaNacimiento", nullable = false, length = 50)
    private LocalDate fechaNacimiento;
    // @Column(name = "Edad", nullable = false, length = 10)
    private Integer edad;

    public Persona() {
        this.dni = null;
        this.nombre = null;
        this.email = null;
        this.fechaNacimiento = null;
        this.edad = null;
    }

    // En este constructo no utlizo el id; lo va a generar mi base de datos
    public Persona(String dni, String nombre, String email, LocalDate fechaNacimiento, Integer edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
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
