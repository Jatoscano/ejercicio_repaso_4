package com.example.demo.uce.edu.repository.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "estudiante", schema = "public")
@Entity
public class Estudiante {

	@Id
	@GeneratedValue(generator = "seq_estudiante", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_estudiante",sequenceName = "seq_estudiante", allocationSize = 1)
	@Column(name = "estu_id")
	private Integer id;
	
	@Column(name = "estu_apellido")
	private String apellido;
	
	@Column(name = "estu_nombre")
	private String nombre;
	
	@Column(name = "estu_cedula")
	private String cedula;
	
	@Column(name = "estu_direccion")
	private String direccion;
	
	@Column(name = "estu_telefono")
	private String telefono;
	
	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
	private List<Matricula> matriculas;

	//To String
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", cedula=" + cedula
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", matriculas=" + matriculas + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
}
