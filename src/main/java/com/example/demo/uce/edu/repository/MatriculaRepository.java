package com.example.demo.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.dto.MatriculaDTO;

public interface MatriculaRepository {

	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public List<MatriculaDTO> listaMatriculas(String cedula, String codigo, LocalDateTime fecha, String nombreHilo);
}
