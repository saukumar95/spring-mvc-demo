package com.saurabh.springdemo.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saurabh.springdemo.mvc.model.Student;
import com.saurabh.springdemo.mvc.util.SessionFactoryBean;

@Controller
@RequestMapping("/student")
public class StudentController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/listStudent")
	public String viewStudent(Model model) {

		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		try {
			session.beginTransaction();
			List<Student> listStudent = session.createQuery("from Student").getResultList();
			model.addAttribute("studentList", listStudent);
			session.getTransaction().commit();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return "list-student";
	}

	@RequestMapping("/showForm")
	public String viewForm(Model model) {
		Student theStudent = new Student();
		model.addAttribute("student", theStudent);
		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult theBindingResult) {
		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		String page = "";
		try {
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			if (theBindingResult.hasErrors()) {
				page = "student-form";
			} else {
				page = "student-confirmation";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return page;
	}

}
