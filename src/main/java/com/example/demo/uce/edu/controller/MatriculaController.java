package com.example.demo.uce.edu.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.uce.edu.repository.model.Estudiante;
import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.dto.MatriculaDTO;
import com.example.demo.uce.edu.service.EstudianteService;
import com.example.demo.uce.edu.service.MateriaService;
import com.example.demo.uce.edu.service.MatriculaService;

@Controller
@RequestMapping("/universidad")
public class MatriculaController {

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	//Estudiante - Para configuracion de vistas
	
	// http://localhost:8080/uce/universidad/registrarEstudiante
	@PostMapping("/registrarEstudiante")
	public String registrarEstudiante(Estudiante estudiante) {
		this.estudianteService.registrar(estudiante);
		return "redirect:/universidad/nuevoEstudiante";
	}

	// Metodo de Pagina de Re-Direccionamiento
	// http://localhost:8080/uce/universidad/nuevoEstudiante
	@GetMapping("/nuevoEstudiante")
	public String paginaNuevoEstudiante(Model model, Estudiante estudiante) {
		model.addAttribute("estudiante", estudiante);
		return "vistaNuevoEstudiante";
	}
		
	//Lista de Estudiantes
	// http://localhost:8080/uce/universidad/reporteEstuidantes
	@GetMapping("/reporteEstudiantes")
	public String reporteEstudiantes(Model modelo) {
				
		List<Estudiante> listaEstudiante = this.estudianteService.reporteEstudiantes();
				
		modelo.addAttribute("universidad", listaEstudiante);
		return "vistaListadoEstudiantes";
	}
	
	//Materia - Para configuracion de vistas
	
	// http://localhost:8080/uce/universidad/registrarMateria
	@PostMapping("/registrarMateria")
	public String registrarMateria(Materia materia) {
		this.materiaService.registrar(materia);
		return "redirect:/universidad/nuevaMateria";
	}

	// Metodo de Pagina de Re-Direccionamiento
	// http://localhost:8080/uce/universidad/nuevaMateria
	@GetMapping("/nuevaMateria")
	public String paginaNuevaMateria(Model model, Materia materia) {
		model.addAttribute("materia", materia);
		return "vistaNuevaMateria";
	}
			
	//Lista de Materias
	// http://localhost:8080/uce/universidad/reporteMaterias
	@GetMapping("/reporteMaterias")
	public String reporteMaterias(Model modelo) {
					
		List<Materia> listaMateria = this.materiaService.reporteMaterias();
					
		modelo.addAttribute("universidad", listaMateria);
		return "vistaListadoMaterias";
	}
	
	//Registro de Matriculas - Vistas
	
	// http://localhost:8080/uce/universidad/registrarMatricula
	@PostMapping("/registrarMatricula")
	public String registrarMatricula(String cedula, String codigo1, String codigo2, String codigo3, String codigo4) {
		this.matriculaService.registrarMatricula(cedula, codigo1, codigo2, codigo3, codigo4);
		return "redirect:/universidad/nuevaMatricula";
	}

	// Metodo de Pagina de Re-Direccionamiento
	// http://localhost:8080/uce/universidad/nuevaMatricula
	@GetMapping("/nuevaMatricula")
	public String paginaNuevaMatricula(Model model, Matricula matricula) {
		model.addAttribute("materia", matricula);
		return "vistaNuevaMatricula";
	}
				
	//Lista de Matriculas
	// http://localhost:8080/uce/universidad/reporteMatriculas
	@GetMapping("/reporteMatriculas")
	public String reporteMatriculas(Model modelo, String cedula, String codigo, LocalDateTime fecha, String nombreHilo) {
						
		List<MatriculaDTO> listaMatricula = this.matriculaService.reporteMatriculas(cedula, codigo, LocalDateTime.now(), nombreHilo);
		for (MatriculaDTO matriculaDTO : listaMatricula) {
			System.out.println(matriculaDTO);
		}				
		modelo.addAttribute("universidad", listaMatricula);
		return "vistaListadoMatriculas";
	}
	
}
