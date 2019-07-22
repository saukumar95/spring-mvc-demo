package com.saurabh.springdemo.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saurabh.springdemo.mvc.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}

	@RequestMapping("/showForm")
	public String viewForm(Model model) {
		Student theStudent = new Student();
		model.addAttribute("student", theStudent);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "student-form";
		} else {
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			System.out.println("FirstName: " + firstName);
			System.out.println("LastName: " + lastName);
			System.out.println("Country: " + student.getCountryName());
			System.out.println("Fav OS: " + student.getFavoriteOperatingSystem());
			return "student-confirmation";
		}

	}

}
