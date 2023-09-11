package com.example.demo.uce.edu.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.EstudianteRepository;
import com.example.demo.uce.edu.repository.MateriaRepository;
import com.example.demo.uce.edu.repository.MatriculaRepository;
import com.example.demo.uce.edu.repository.model.Estudiante;
import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.dto.MatriculaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	private static final Logger LOGGER = LoggerFactory.getLogger(MateriaServiceImpl.class);
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public void registrar(Matricula matricula) {
		
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public void guardar(Matricula matricula) {
		
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	public Matricula buscar(Integer id) {
		
		return this.matriculaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.matriculaRepository.eliminar(id);
	}

	
	@Override
	public void registrarMatricula(String cedula, String codigo1, String codigo2, String codigo3, String codigo4) {
		
		LOGGER.info("Hilo Matricula: "+ Thread.currentThread().getName());
		
		//1. Cramos un objeto Lista para manejas los hilos 
		List<Materia> registro = new ArrayList<>();
		long tiempoInicial = System.currentTimeMillis();
		
		//2. Creamos el objeto Materia
		Materia materia1 = this.materiaRepository.seleccionarCodigo(codigo1);
		Materia materia2 = this.materiaRepository.seleccionarCodigo(codigo2);
		Materia materia3 = this.materiaRepository.seleccionarCodigo(codigo3);
		Materia materia4 = this.materiaRepository.seleccionarCodigo(codigo4);
		
		registro.add(materia1);
		registro.add(materia2);
		registro.add(materia3);
		registro.add(materia4);
		
		registro.parallelStream().forEach(materias ->{
			//3.1 Validamos un Estudiante
			Estudiante estudiante = this.estudianteRepository.seleccionarCedula(cedula);
			
			//3.2 Creamos un  hilo para la insecion
			Thread hilo = new Thread();
			
			//3.3 Creamos una variable String para nuestro hilo
			String hiloFinal = hilo.getName().toString();
			
			//3.4 Creamos el objeto Matricula
			
			Matricula matricula = new Matricula();	
			
			matricula.setFecha(LocalDateTime.now());
			matricula.setNombreHilo(hiloFinal);
			
			matricula.setEstudiante(estudiante);
			matricula.setMateria(materia1);
			matricula.setMateria(materia2);
			matricula.setMateria(materia3);
			matricula.setMateria(materia4);
			
			this.registrar(matricula);
		});
		
		//Tiempo en demorar la tramsaccion
		long tiempoFinal = System.currentTimeMillis();
	    long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
	    LOGGER.info("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));
	    LOGGER.info("Tiempo Transcurrido: "+tiempoTranscurrido);
		
	}

	@Override
	public List<MatriculaDTO> reporteMatriculas(String cedula, String codigo, LocalDateTime fecha, String nombreHilo) {
		
		return this.matriculaRepository.listaMatriculas(cedula, codigo, fecha, nombreHilo);
	}
}
