package com.thymeleaf.controller;

import java.net.http.HttpRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String openHelloWorldForm() {
		return "helloWorld-form";
	}
	@RequestMapping("/submitForm")
	public String submitHelloWorldForm() {
		return "result-page";
	}
	@RequestMapping("/submitFormVersion2")
	public String processForm(HttpServletRequest req, Model model) {
		// Fetch student Name from the form
		String theName = req.getParameter("studentName");
		// Convert the text to upper case
		String upperCaseName=theName.toUpperCase();
		// bind the name into model object
		model.addAttribute("Student_Name", upperCaseName);
		return "result-page";
	}
	@PostMapping("/submitFormVersion3")
	public String processFormVersion2(@RequestParam("studentName") String theName, Model model) {
		// convert the text to upper case
		theName= theName.toUpperCase();
		// bind the name into model object
		model.addAttribute("Student_Name",theName);
		return "result-page";
	}
}