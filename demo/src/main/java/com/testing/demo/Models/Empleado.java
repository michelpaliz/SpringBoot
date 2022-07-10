package com.testing.demo.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.resources.*;



import com.testing.demo.Numeric.EProfesion;
@Entity
@Table(name = "empleados")

public class Empleado extends Persona {
    private static int cont;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Profesion", nullable = false, length =  50)
    private EProfesion profesion;
    @Column(name = "Antiguedad", nullable = false, length = 5)
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

    public EProfesion getProfesion() {
        return profesion;
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
