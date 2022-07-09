package com.testing.demo.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends Persona {
    private boolean administrador;
    private List<Empleado> empleados;

    public Administrador(String dni, String nombre, String emai, LocalDate fechaNacimiento, Integer edad,
            boolean administrador) {
        super(dni, nombre, emai, fechaNacimiento, edad);
        this.administrador = administrador;
        empleados = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "administrador=" + administrador +
                ", empleados=" + empleados +
                '}';
    }
}
