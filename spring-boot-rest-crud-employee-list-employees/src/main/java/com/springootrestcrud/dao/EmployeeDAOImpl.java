package com.springootrestcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springootrestcrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class EmployeeDAOImpl  implements EmployeeDAO{

	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
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
