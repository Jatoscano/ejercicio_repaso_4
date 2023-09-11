package com.example.demo.uce.edu.repository.model.dto;

import java.time.LocalDateTime;

public class MatriculaDTO {

	private String cedula;
	private String codigo;
	private LocalDateTime fecha;
	private String nombreHilo;
	
	//Constructor por defecto
	public MatriculaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MatriculaDTO(String cedula, String codigo, LocalDateTime fecha, String nombreHilo) {
		this.cedula = cedula;
		this.codigo = codigo;
		this.fecha = fecha;
		this.nombreHilo = nombreHilo;
	}

	//To String
	@Override
	public String toString() {
		return "MatriculaDTO [cedula=" + cedula + ", codigo=" + codigo + ", fecha=" + fecha + ", nombreHilo="
				+ nombreHilo + "]";
	}

	//Get and Set
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}
}
