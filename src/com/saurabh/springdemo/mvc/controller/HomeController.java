package com.saurabh.springdemo.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
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

	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("sname") String sname, Model model) {
		sname = sname.toUpperCase();
		String newName = "Yo!!" + sname;
		model.addAttribute("message", newName);
		return "process-form";
	}
}
