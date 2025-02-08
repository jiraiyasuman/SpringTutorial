package com.springootrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springootrestcrud.entity.Employee;
import com.springootrestcrud.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	@Override
	public List<Employee> findAll() {
		// get all the list of employees
		List<Employee> employeeList = employeeRepository.findAll();
		
		return employeeList;
	}
	@Override
	public Employee findById(int id) {
		// find the employee by id
		Employee employee = employeeRepository.findById(id).get();
		if(employee == null) {
			throw new RuntimeException("Employee id is not found"+id);
		}
		
		// return employee
		return employee;
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		// save the employee in the database
		Employee employe = employeeRepository.save(employee);
		return employe;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		
		// delete the employee details
		employeeRepository.deleteById(id);
		
	}
}
