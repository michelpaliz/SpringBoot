package com.testing.demo.Models;

import java.time.LocalDate;

import com.testing.demo.Numeric.EProfesion;

public class Empleado extends Persona {
    private static int cont;
    private long id;
    private EProfesion profesion;
    private int antiguedad;

    public Empleado(String dni, String nombre, String emai, LocalDate fechaNacimiento, Integer edad,
            EProfesion profesion,
            int antiguedad) {
        super(dni, nombre, emai, fechaNacimiento, edad);
        ++cont;
        this.id = cont;
        this.profesion = profesion;
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " id=" + id +
                ", profesion=" + profesion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}
