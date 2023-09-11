package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.EstudianteRepository;
import com.example.demo.uce.edu.repository.model.Estudiante;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void registrar(Estudiante estudiante) {
		
		this.estudianteRepository.insertar(estudiante);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void guardar(Estudiante estudiante) {
		
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante buscar(Integer id) {
		
		return this.estudianteRepository.seleccionar(id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void borrar(Integer id) {
		
		this.estudianteRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Estudiante> reporteEstudiantes() {
		
		return this.estudianteRepository.listaEstudiantes();
	}
}
