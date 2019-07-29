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
import org.springframework.web.bind.annotation.PathVariable;
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
			if (!listStudent.isEmpty()) {
				model.addAttribute("studentList", listStudent);
				session.getTransaction().commit();
			} else {
				return "redirect:/student/showForm";
			}
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
	public String processForm(@ModelAttribute("student") @Valid Student student, BindingResult theBindingResult) {
		String page = "";
		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		try {
			if (theBindingResult.hasErrors()) {
				page = "student-form";
			} else {
				session.beginTransaction();
				Long id = (Long) session.save(student);
				session.getTransaction().commit();
				page = "redirect:/student/showStudent/" + id;
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return page;
	}

	@RequestMapping(value = "/showStudent/{id}")
	public String showStudent(@PathVariable("id") String id, Model model) {
		String page = "";
		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, Long.parseLong(id));
			model.addAttribute("student", student);
			session.getTransaction().commit();
			page = "show-student";
//			if (student != null) {
//				
//			} else {
//				return "redirect:/student/listStudent";
//			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return page;
	}

	@RequestMapping(value = "/updateStudent/{id}")
	public String updateStudent(@PathVariable("id") Long id, Model model) {
		String page = "";
		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				model.addAttribute("command", student);
				model.addAttribute("countryOptions", new Student().getCountryOptions());
				session.getTransaction().commit();
				page = "update-student";
			} else {
				return "redirect:/student/listStudent";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return page;
	}

	@RequestMapping(value = "/updateAndSave")
	public String saveUpdatedStudent(@Valid @ModelAttribute("students") Student student,
			BindingResult theBindingResult) {
		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		String page = "";
		try {
			if (theBindingResult.hasErrors()) {
				page = "redirect:/student/updateStudent/" + student.getId();
			} else {
				session.beginTransaction();
				session.saveOrUpdate(student);
				session.getTransaction().commit();
				page = "redirect:/student/showStudent/" + student.getId();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return page;
	}

	@RequestMapping(value = "/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		String page = "";
		Session session = SessionFactoryBean.getInstance().getCurrentSession();
		try {
			session.beginTransaction();
			Student student = session.get(Student.class, id);
			if (student != null) {
				session.delete(student);
				session.getTransaction().commit();
				page = "redirect:/student/listStudent";
			} else {
				return "redirect:/student/listStudent";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			session.close();
		}
		return page;
	}
}
