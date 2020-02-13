package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;

@Service
public class TeachersService {

	private List<Teacher> teachersList = new LinkedList<Teacher>();
	 @PostConstruct
	 public void init(){
		 teachersList.add(new Teacher(1L, "Rodolfo", "Rodriguez Ramen", "A"));
		 teachersList.add(new Teacher(2L, "Ernesto", "Jimenez Ramen", "B"));
		 teachersList.add(new Teacher(3L, "Carlota", "Pelaez Ramen", "C"));
	 }
	
	public void addTeacher(Teacher teacher) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		teachersList.add(teacher);
	}
	
	public List<Teacher> getTeachers(){
		return teachersList;
	}
	
	public Teacher getTeacher(Long id){
		return teachersList.stream()
		.filter(teacher -> teacher.getDNI().equals(id)).findFirst().get();
	}
	
	public void deleteTeacher(Long id){
		teachersList.removeIf(teacher -> teacher.getDNI().equals(id));
	}
	
	
	
}
