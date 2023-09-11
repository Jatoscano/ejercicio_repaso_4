package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.MateriaRepository;
import com.example.demo.uce.edu.repository.model.Materia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements MateriaService{

	@Autowired
	private MateriaRepository materiaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrar(Materia materia) {
		
		this.materiaRepository.insertar(materia);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Materia materia) {
		
		this.materiaRepository.actualizar(materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia buscar(Integer id) {
		
		return this.materiaRepository.seleccionar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void borrar(Integer id) {
		
		this.materiaRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Materia> reporteMaterias() {
		
		return this.materiaRepository.listaMaterias();
	}
}
