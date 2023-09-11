package com.example.demo.uce.edu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements MatriculaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		
		this.entityManager.persist(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		
		this.entityManager.merge(matricula);
	}

	@Override
	public Matricula seleccionar(Integer id) {
		
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public List<MatriculaDTO> listaMatriculas(String cedula, String codigo, LocalDateTime fecha, String nombreHilo) {
		
		TypedQuery<MatriculaDTO> typedQuery = this.entityManager.createQuery(
				"SELECT NEW com.example.demo.uce.edu.repository.model.dto.MatriculaDTO"
			  + "(mt.estudiante.cedula, mt.materia.codigo, mt.fecha, mt.nombreHilo) "
			  + "FROM Matricula mt", MatriculaDTO.class);
		return typedQuery.getResultList();
	}
}
