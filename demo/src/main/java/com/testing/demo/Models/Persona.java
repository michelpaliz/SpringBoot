package com.testing.demo.Models;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ManyToAny;

import lombok.Data;
import lombok.NonNull;

// @Table(name = "empleados")
@Data
@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numero_registro;
    // @NotNull
    // @Size(min = 9, max = 9, message = "El dni no es correcto")
    private String dni;
    // @NotNull
    // @Size(message = "El nombre es requerido")
    private String nombre;
    // @NotNull
    // @Email
    private String email;
    // @NotNull(message = "fecha incorrecta")
    private LocalDate fechaNacimiento;
    // @NotNull(message = "edad incorrecta")
    private Integer edad;

    public Persona() {
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
