package com.testing.demo;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.testing.demo.Models.Estudiante;

@SpringBootApplication
@RestController // esto hace que nuestra clase reciba restpoints
public class DemoApplication {

	private Estudiante estudiante;
	private List<Estudiante> estudiantes;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	// vamos a coger algo de nuestro servidor para exportarlo.
	public List<Estudiante> randomEstudiantes() {
		estudiantes = new ArrayList<>();
		Faker fk = new Faker();
		Date fechaMaxima = new GregorianCalendar(1999, Calendar.FEBRUARY, 11).getTime();
		Date fechaMinima = new GregorianCalendar(1980, Calendar.FEBRUARY, 11).getTime();
		for (int i = 0; i < 10; i++) {
			String nombre = fk.name().firstName();
			String email = fk.name().username() + "@homtail.com";
			Date date = fk.date().between(fechaMinima, fechaMaxima);
			LocalDate fechaNacimiento = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Integer edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
			estudiante = new Estudiante(nombre, email, fechaNacimiento, edad);
			estudiantes.add(estudiante);
		}
		return estudiantes;

	}

}
