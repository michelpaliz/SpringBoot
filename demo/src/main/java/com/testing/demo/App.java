package com.testing.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.testing.demo.Models.Empleado;

@SpringBootApplication
// @RestController // esto hace que nuestra clase reciba restpoints
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
