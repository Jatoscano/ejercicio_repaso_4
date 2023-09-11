package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Estudiante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Estudiante estudiante) {
		
		this.entityManager.persist(estudiante);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Estudiante estudiante) {
		
		this.entityManager.merge(estudiante);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante seleccionar(Integer id) {
		
		return this.entityManager.find(Estudiante.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Estudiante seleccionarCedula(String cedula) {
		//SQL
		//SELECT * FROM estudiante e WHERE e.estu_cedula = "" 
												
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Estudiante e WHERE e.cedula = :""
		TypedQuery<Estudiante> typedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE "
				+ "															e.cedula = :datoCedula", Estudiante.class);
		typedQuery.setParameter("datoCedula", cedula);
		return typedQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Estudiante> listaEstudiantes() {
		//SQL
		//SELECT * FROM estudiante e  
										
		//JPQL
		//Se mantienen las palabras reservadas 
		//SELECT e FROM Estudiante e
		TypedQuery<Estudiante> typedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", 
																			Estudiante.class);
		return typedQuery.getResultList();
	}
	
	

}
