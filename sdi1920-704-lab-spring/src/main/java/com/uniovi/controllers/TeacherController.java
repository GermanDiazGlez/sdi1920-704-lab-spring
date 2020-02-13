package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@RestController
public class TeacherController {
	
	@Autowired //Inyectar el servicio
	private TeachersService teachersService;

	@RequestMapping(value="/teacher/add", method=RequestMethod.POST)
	public String addTeacher(@RequestParam String dNI, @RequestParam String nombre, @RequestParam String apellidos, @RequestParam String categoria) {
		Teacher teacher = new Teacher(Long.valueOf(dNI), nombre, apellidos, categoria);
		teachersService.addTeacher(teacher);
		return "Añadiendo profesor : " + teacher.toString();
	}

	@RequestMapping("/teacher/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return teachersService.getTeacher(id).toString();

	}

	@RequestMapping("/teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teachersService.deleteTeacher(id);
		return "Eliminando profesor con DNI: " + id;
	}

	@RequestMapping("/teacher/edit/{id}")
	public String getEdit(@PathVariable Long id) {
		return "Editar profesor " + id;
	}
	
	@RequestMapping("/teacher/list")
	public String getList() {
		return teachersService.getTeachers().toString();
	}
}
