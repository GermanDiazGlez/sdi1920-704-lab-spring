package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@Controller
public class TeachersControllers {

	@Autowired
	private TeachersService teachersService;

	@RequestMapping("/teacher/add")
	public String setTeacher() {
		return "/teacher/add";
	}

	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String setTeacher(@ModelAttribute Teacher teacher) {
		teachersService.addTeacher(teacher);
		return "redirect:/teacher/list";
	}

	@RequestMapping("/teacher/delete/{dni}")
	public String deleteTeacher(@PathVariable Long dni) {
		teachersService.deleteTeacher(dni);
		return "redirect:/teacher/list";
	}

	@RequestMapping("/teacher/list")
	public String listTeachers(Model model) {
		model.addAttribute("teachers", teachersService.getTeachers());
		return "teacher/list";
	}

	@RequestMapping("/teacher/edit")
	public String editTeacher() {
		return "Editando datos del profesor";
	}

	@RequestMapping("/teacher/details/{dni}")
	public String getDetailTeacher(@PathVariable Long dni) {
		return teachersService.getTeacher(dni).toString();
	}

}
