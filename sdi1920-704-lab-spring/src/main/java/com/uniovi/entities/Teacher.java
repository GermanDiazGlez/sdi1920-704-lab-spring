package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Teacher {

	@Id
	private String dni;
	private String nombre;
	private String apellidos;
	private String categoria;

	public Teacher() {
		super();
	}

	public Teacher(String dni, String nombre, String apellidos, String categoria) {
		super();
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
		setCategoria(categoria);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Teacher [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", categoria=" + categoria
				+ "]";
	}

}
