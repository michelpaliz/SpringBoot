package com.testing.demo.Models;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.testing.demo.Numeric.EProfesion;

@Entity
// @IdClass(Empleado.class)
public class Empleado extends Persona implements Serializable {
    private static long cont;
    // @Id
    private long id;
    // @NotNull(message = "La profesion es necesaria")
    @Enumerated(value = EnumType.STRING)
    // @Pattern(regexp = "jardinero|piscinero|podador_palmeras")
    private EProfesion profesion;
    // @NotNull
    private long antiguedad;

    public Empleado() {
        super();
        ++cont;
        this.id = cont;
    }

    public Empleado(String dni, String nombre, String emai, LocalDate fechaNacimiento, EProfesion profesion,
            long antiguedad) {
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
