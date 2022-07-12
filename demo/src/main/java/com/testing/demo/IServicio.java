package com.testing.demo;

import java.util.List;

import com.testing.demo.Models.Empleado;
import com.testing.demo.Models.Persona;

public interface IServicio {

    public Iterable<Persona> mostrarEmpleados();
    
}
