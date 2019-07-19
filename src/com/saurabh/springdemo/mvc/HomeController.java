package com.saurabh.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping("/")
	public String showMyPage() {
		return "home";
	}

	@RequestMapping("/inputform")
	public String getInputForm() {
		return "inputform";
	}

	@RequestMapping("/showform")
	public String getShowForm() {
		return "showform";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}

	@RequestMapping("/processFormVersionTwo")
	public String advanceProcessForm(HttpServletRequest request, Model model) {
		String name = request.getParameter("sname");
		name = name.toUpperCase();
		String newName = "Yo!! " + name;
		model.addAttribute("message", newName);
		return "process-form";
	}
}
