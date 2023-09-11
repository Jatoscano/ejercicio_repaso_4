package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Estudiante;
import com.example.demo.uce.edu.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		
		this.entityManager.merge(materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionar(Integer id) {
		
		return this.entityManager.find(Materia.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}
	
	

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionarCodigo(String codigo) {
		//SQL
		//SELECT * FROM materia ma WHERE ma.mate_codigo = "" 
														
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT ma FROM Materia ma WHERE ma.codigo = :""
		Query query = this.entityManager.createQuery("SELECT ma FROM Materia ma WHERE "
																	  + "ma.codigo = :datoCodigo", Materia.class);
		query.setParameter("datoCodigo", codigo);
		return (Materia) query.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Materia> listaMaterias() {
		//SQL
		//SELECT * FROM materia ma
												
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT ma FROM Materia ma
		TypedQuery<Materia> typedQuery = this.entityManager.createQuery("SELECT ma FROM Materia ma", 
																					Materia.class);
		return typedQuery.getResultList();
	}
}
