package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@Controller
public class TeacherController {
	
	@Autowired //Inyectar el servicio
	private TeachersService teachersService;

	
	@RequestMapping("/teacher/add")
	public String addTeacher() {
		return "/teacher/add";
	}
	
	@RequestMapping(value="/teacher/add", method=RequestMethod.POST)
	public String addTeacher(@ModelAttribute Teacher teacher) {
		teachersService.addTeacher(teacher);
		return "redirect:/teacher/list";
	}
	
	

	@RequestMapping("/teacher/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return teachersService.getTeacher(id).toString();

	}

	@RequestMapping("/teacher/delete/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teachersService.deleteTeacher(id);
		return "redirect:/teacher/list";
	}

	@RequestMapping("/teacher/edit/{id}")
	public String getEdit(@PathVariable Long id) {
		return "Editar profesor " + id;
	}
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("teachersList", teachersService.getTeachers());
		return "teacher/list";
	}
}
