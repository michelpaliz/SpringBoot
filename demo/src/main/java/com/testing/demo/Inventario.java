package com.testing.demo;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import com.Lib.Control;
import com.github.javafaker.Faker;
import com.testing.demo.Models.Empleado;
import com.testing.demo.Numeric.EProfesion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@RequestMapping("/empleados")

public class Inventario {
	private Empleado empleado;
	private List<Empleado> empleados;

    @GetMapping
	// vamos a coger algo de nuestro servidor para exportarlo.
	public String randomEmpleados() {
		empleados = new ArrayList<>();
		Faker fk = new Faker();
		Date fechaMaxima = new GregorianCalendar(1999, Calendar.FEBRUARY, 11).getTime();
		Date fechaMinima = new GregorianCalendar(1980, Calendar.FEBRUARY, 11).getTime();
		EProfesion profesion = EProfesion.jardinero;
		for (int i = 0; i < 10; i++) {
			String formato = fk.number().digits(8);
			String dni = Control.DNIgeneratorChar(formato);
			String nombre = fk.name().firstName();
			String email = fk.name().username() + "@homtail.com";
			Date date = fk.date().between(fechaMinima, fechaMaxima);
			LocalDate fechaNacimiento = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Integer edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
			profesion = profesion.getRandom();
			int antiguedad = fk.random().nextInt(0, 10);
			empleado = new Empleado(dni, nombre, email, fechaNacimiento, edad, profesion, antiguedad);
			empleados.add(empleado);
		}
		return empleados.toString();
	}

    

}
