package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class PwU4P4TJaApplication implements CommandLineRunner{
	@Autowired
	private IEstudianteService estudianteService;
	public static void main(String[] args) {
		SpringApplication.run(PwU4P4TJaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estudiante	es = new Estudiante();
		es.setNombre("Jhon");
		es.setApellido("Arteaga");
		es.setCedula("1720368248");
		es.setEdad(22);
		
		//this.estudianteService.agregar(es);
		//this.estudianteService.borrar(2);
		System.out.println(this.estudianteService.encontrarPorCedula(es.getCedula()));
		
	}

}
