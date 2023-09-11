package com.example.demo.uce.edu.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.dto.MatriculaDTO;

public interface MatriculaService {

	public void registrar(Matricula matricula);
	public void guardar(Matricula matricula);
	public Matricula buscar(Integer id);
	public void borrar(Integer id);
	
	public void registrarMatricula(String cedula, String codigo1, String codigo2, String codigo3, String codigo4);
	public List<MatriculaDTO> reporteMatriculas(String cedula, String codigo, LocalDateTime fecha, String nombreHilo);
}
