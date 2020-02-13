package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private Long dNI;
	private String nombre;
	private String apellidos;
	private String categoria;
	
	public Teacher(Long dNI, String nombre, String apellidos, String categoria) {
		super();
		setDNI(dNI);
		setNombre(nombre);
		setApellidos(apellidos);
		setCategoria(categoria);
	}

	public Teacher() {
		super();
	}

	public Long getDNI() {
		return dNI;
	}

	private void setDNI(long dNI) {
		this.dNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCategoria() {
		return categoria;
	}

	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Override
	public String toString() {
		return "Teacher [DNI=" + dNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", categoria=" + categoria
				+ "]";
	}
	
}
