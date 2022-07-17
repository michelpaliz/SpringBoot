package com.testing.demo.Models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.servlet.resources.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.testing.demo.Numeric.EProfesion;

import lombok.Data;

@Entity
// @IdClass(Empleado.class)
public class Empleado extends Persona implements Serializable {
    private static long cont;
    // @Id
    private long id;
    @Enumerated(value = EnumType.STRING)
    private EProfesion profesion;
    @NotNull(message = "la antiguedad es requerida")
    private long antiguedad;

    public Empleado() {
        super();
    }

    public Empleado(String dni, String nombre, String emai, LocalDate fechaNacimiento, EProfesion profesion,
            int antiguedad) {
        super(dni, nombre, emai, fechaNacimiento);
        ++cont;
        this.id = cont;
        this.profesion = profesion;
        this.antiguedad = antiguedad;
    }

    public EProfesion getProfesion() {
        return profesion;
    }

    public static long getCont() {
        return cont;
    }

    public long getId() {
        return id;
    }

    public long getAntiguedad() {
        return antiguedad;
    }

    @Override
    public String toString() {
        return super.toString() +
                " id=" + id +
                ", profesion=" + profesion +
                ", antiguedad=" + antiguedad +
                '}';
    }

}
