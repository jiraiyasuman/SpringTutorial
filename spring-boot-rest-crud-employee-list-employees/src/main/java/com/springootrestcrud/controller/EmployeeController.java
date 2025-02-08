package com.springootrestcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springootrestcrud.dao.EmployeeDAO;
import com.springootrestcrud.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeController(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}
	@GetMapping("/find")
	public List<Employee> getAll(){
		return employeeDAO.findAll();
	}
	
}
