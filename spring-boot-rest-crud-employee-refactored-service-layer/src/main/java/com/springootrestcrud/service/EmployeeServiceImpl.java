package com.springootrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springootrestcrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EntityManager entityManager;
	@Autowired
	public EmployeeServiceImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> listOfEmployee = entityManager.createQuery("from Employee",Employee.class);
		List<Employee> employeeList = listOfEmployee.getResultList();
		
		return employeeList;
	}
}
