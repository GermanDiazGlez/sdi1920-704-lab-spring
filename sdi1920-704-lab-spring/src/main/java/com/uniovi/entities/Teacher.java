package com.uniovi.entities;

import javax.persistence.*;

@Entity
public class Teacher {

	@Id
	private Long dNI;
	private String nombre;
	private String apellidos;
	private String categoria;
	
	public Teacher(Long dNI, String nombre, String apellidos, String categoria) {
		super();
		this.dNI=dNI;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.categoria=categoria;
	}

	public Teacher() {
		super();
	}

	public Long getDNI() {
		return dNI;
	}

	public void setDNI(long dNI) {
		this.dNI = dNI;
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
		return "Teacher [DNI=" + dNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", categoria=" + categoria
				+ "]";
	}
	
}
