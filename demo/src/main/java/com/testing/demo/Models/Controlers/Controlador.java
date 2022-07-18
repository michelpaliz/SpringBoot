package com.testing.demo.Models.Controlers;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.Lib.Control;
import com.github.javafaker.Faker;
import com.testing.demo.App;
import com.testing.demo.Models.Empleado;
import com.testing.demo.Models.Persona;
import com.testing.demo.Models.repository.EmpleadoRepositorio;
import com.testing.demo.Models.repository.PersonaRepositorio;
import com.testing.demo.Numeric.EProfesion;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
// @SessionAttributes("empleado")
public class Controlador {
	private App app;
	@Autowired
	private EmpleadoRepositorio empleadoRepositorio;
	private PersonaRepositorio personaRepositorio;
	private Empleado empleado;
	private List<Empleado> empleados;

	public Iterable<Empleado> mostrarEmpleados() {
		return empleadoRepositorio.findAll();
		// return empleadoRepositorio.findAll();
	}

	@ModelAttribute
	// vamos a coger algo de nuestro servidor para exportarlo.
	public String randomEmpleados() {
		app = new App();
		empleadoRepositorio = app.getEmpleadoRepositorio();
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
			// Integer edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
			profesion = profesion.getRandom();
			int antiguedad = fk.random().nextInt(0, 10);
			empleado = new Empleado(dni, nombre, email, fechaNacimiento, profesion, antiguedad);
			empleadoRepositorio.save(empleado);
			empleados.add(empleado);
		}
		return empleados.toString();
	}

	@GetMapping("/")
	public String mostrarTipoProfesion(Model model) {
		randomEmpleados();
		model.addAttribute("empleados", mostrarEmpleados());
		// for (Empleado empleado : empleados) {
		// // model.addAttribute("empleados", clasificarTipo(empleado.getProfesion()));
		// }
		System.out.println(empleados);
		return "index";
	}

	// Esta funcion me crea un nuevo empleado y me lleva al registro.html
	@GetMapping("/registrarEmpleado")
	public String nuevoEmpleado(Model model) {
		model.addAttribute("nuevoEmpleado", new Empleado());
		return "registroEmpleado";
	}

	// Esta funcion me guarda el empleado nuevo que he creado en el registro.html y
	// me redirecciona el registro para que me lo valide correctamente
	// @PostMapping("/registro")
	// public String procesarRegistro(Empleado empleado) {
	// empleadoRepositorio.save(empleado);
	// System.out.println(empleado);
	// log.info("Peticion enviada " + empleado);
	// return "redirect:/procesando";
	// }
	@PostMapping("/registro")
	public String registrarEmpleado(@Valid @ModelAttribute("nuevoEmpleado") Empleado empleado, Errors errors) {
		// System.out.println(empleado);

		if (errors.hasErrors()) {
			// empleadoRepositorio.delete(empleado);
			return "/registroEmpleado";
		}
		empleadoRepositorio.save(empleado);
		System.out.println(empleado);
		// log.info("Peticion enviada " + empleado);
		// log.info("Procesando el registro" + empleado);
		return "redirect:/";
	}

	@ModelAttribute
	public Iterable<Empleado> clasificarTipo(EProfesion profesion) {
		return empleados.stream().filter(x -> x.getProfesion().equals(profesion)).collect(Collectors.toList());
	}

}
