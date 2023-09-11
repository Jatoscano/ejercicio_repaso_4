package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Estudiante;

public interface EstudianteRepository {

	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public Estudiante seleccionarCedula(String cedula);
	public List<Estudiante> listaEstudiantes();
}
