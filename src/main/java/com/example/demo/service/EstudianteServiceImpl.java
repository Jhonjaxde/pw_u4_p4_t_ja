package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
@Service
public class EstudianteServiceImpl implements IEstudianteService{
	@Autowired
	private IEstudianteRepository estudianteRepo;
	
	@Override
	public void agregar(Estudiante estudiante) {
	this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	public void modificar(Estudiante estudiante) {
	this.estudianteRepo.actualizar(estudiante);	
		
	}

	@Override
	public Estudiante encontrar(Integer id) {
	
		return this.estudianteRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		this.estudianteRepo.eliminar(id);
		
	}

	@Override
	public Estudiante encontrarPorCedula(String cedula) {
		return this.estudianteRepo.seleccionarPorCedula(cedula);
	}

}
