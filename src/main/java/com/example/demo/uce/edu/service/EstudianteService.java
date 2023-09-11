package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Estudiante;

public interface EstudianteService {

	public void registrar(Estudiante estudiante);
	public void guardar(Estudiante estudiante);
	public Estudiante buscar(Integer id);
	public void borrar(Integer id);
	
	public List<Estudiante> reporteEstudiantes();
}
