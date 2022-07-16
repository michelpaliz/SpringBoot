package com.testing.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import com.testing.demo.Models.Empleado;
import com.testing.demo.Models.repository.EmpleadoRepositorio;
import com.testing.demo.Models.repository.PersonaRepositorio;

@SpringBootApplication
// @RestController // esto hace que nuestra clase reciba restpoints
public class App {
	private static PersonaRepositorio personaRepositorio;
	private static EmpleadoRepositorio empleadoRepositorio;
	private static ConfigurableApplicationContext configuracion;
	// private static Controlador;

	public static void main(String[] args) {
		// SpringApplication.run(App.class, args);

		configuracion = SpringApplication.run(App.class,
				args);

		empleadoRepositorio = configuracion.getBean(EmpleadoRepositorio.class);

		// c.randomEmpleados(empleado);

	}

	public PersonaRepositorio getPersonaRepositorio() {
		return personaRepositorio;
	}

	public EmpleadoRepositorio getEmpleadoRepositorio() {
		return empleadoRepositorio;
	}

}
