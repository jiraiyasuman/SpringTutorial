package com.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymeleaf.entity.Student;

@Controller
public class StudentController {

	@Value("${countries}")
	List<String> country;
	@RequestMapping("/")
	public String getHomePage(Model model) {
		model.addAttribute("theDate", java.time.LocalDateTime.now());
		return "index";
	}
	@GetMapping("/openForm")
	public String openFormPage(Model model) {
		
		model.addAttribute("Student", new Student());
		model.addAttribute("country", country);
		return "student";
	}
	/*
	 * @PostMapping("/submit") public String
	 * submitForm(@ModelAttribute("Student")Student student,Model model) { String
	 * fullName=student.getFirstName()+student.getLastName();
	 * model.addAttribute("Student", fullName);
	 * System.out.println("The details are:"+student.getFirstName()+" "+student.
	 * getLastName()); return "result-page"; }
	 */
	@PostMapping("/submit")
	public String processForm(@ModelAttribute("Student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "result-page";
    }
}
