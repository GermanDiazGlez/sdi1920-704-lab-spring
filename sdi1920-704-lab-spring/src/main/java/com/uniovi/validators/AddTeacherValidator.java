package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@Component
public class AddTeacherValidator implements Validator {

	@Autowired
	private TeachersService teachersService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Teacher.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Teacher teacher = (Teacher) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		if (teacher.getDni().length() < 9 || teacher.getDni().length() > 9) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
		else if (!Character.isLetter(teacher.getDni().charAt(8))) {
			errors.rejectValue("dni", "Error.teacher.signup.dni.notLetter");
		}
		if (teachersService.getTeacherByDni(teacher.getDni()) != null) {
			errors.rejectValue("dni", "Error.signup.dni.duplicate");
		}
		if (teacher.getNombre().length() < 5 || teacher.getNombre().length() > 24) {
			errors.rejectValue("nombre", "Error.signup.name.length");
		}
		if (teacher.getApellidos().length() < 5 || teacher.getApellidos().length() > 24) {
			errors.rejectValue("apellidos", "Error.signup.lastName.length");
		}

	}

}
