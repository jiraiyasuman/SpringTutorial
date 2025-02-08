package com.springootrestcrud.controller;

import java.util.List;


import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springootrestcrud.entity.Employee;
import com.springootrestcrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	/*
	 * private EmployeeDAO employeeDAO;
	 * 
	 * @Autowired public EmployeeController(EmployeeDAO employeeDAO) { super();
	 * this.employeeDAO = employeeDAO; }
	 */
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// gets the list of employees from the database
	@GetMapping("/employee")
	public List<Employee> getAll(){
		return employeeService.findAll();
	}
	// gets the employee by the id
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee employee=employeeService.findById(id);
		if(employee==null) {
			throw new RuntimeException("Employee id is not found"+id);
		}
		return employee;
	}
	// inserts an employee record in the database
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		Employee emp = employeeService.save(employee);
		return emp;
	}
	// updating the employee records in the database
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.save(employee);
		return emp;
	}
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		// find the employee by id
		Employee employee=employeeService.findById(id);
		// throw an exception if id is null
		if(employee==null) {
			throw new RuntimeException("Employee id is not found"+id);
		}
		// delete the employee details if id is not null
		employeeService.deleteById(id);
		return "Employee Record: "+id+", has been deleted from the database......";
	}
}
