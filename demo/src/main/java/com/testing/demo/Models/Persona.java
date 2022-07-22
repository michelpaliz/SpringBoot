package com.testing.demo.Models;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.aspectj.lang.annotation.After;

import com.testing.demo.Models.interfaces.IFechaNacimiento;

import lombok.Data;

// @Table(name = "empleados")
@Data
@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numero_registro;
    @NotNull
    @Size(min = 9, max = 9, message = "El dni no es correcto")
    private String dni;
    @NotNull
    @Size(min = 1, message = "El nombre es requerido")
    private String nombre;
    @NotNull
    @Email(message = "El email debe ser valido")
    @Size(min = 1, message = "El email es requerido")
    private String email;
    // @NotNull(message = "fecha incorrecta")
    @NotNull(message = "La fecha de nacimiento es requerida")
    @IFechaNacimiento("2000-01-01")
    private LocalDate fechaNacimiento;
    private Integer edad;

    public Persona() {
    }

    // En este constructo no utlizo el id; lo va a generar mi base de datos
    public Persona(String dni, String nombre, String email, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad();
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
