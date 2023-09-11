package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Materia;

public interface MateriaRepository {

	public void insertar(Materia materia);
	public void actualizar(Materia materia);
	public Materia seleccionar(Integer id);
	public void eliminar(Integer id);
	
	public Materia seleccionarCodigo(String codigo);
	public List<Materia> listaMaterias();
}
