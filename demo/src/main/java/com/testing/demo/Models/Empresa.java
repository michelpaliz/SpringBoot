package com.testing.demo.Models;

import java.time.LocalDate;

public class Empresa {
    private String nombre;
    private LocalDate anyoFundacion;
    private Administrador administrador;


    public Empresa(String nombre, LocalDate anyoFundacion, Administrador administrador) {
        this.nombre = nombre;
        this.anyoFundacion = anyoFundacion;
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Empresa [administrador=" + administrador + ", anyoFundacion=" + anyoFundacion + ", nombre=" + nombre
                + "]";
    }


}
