package com.springootrestcrud.dao;

import java.util.List;

import com.springootrestcrud.entity.Employee;

public interface EmployeeDAO {

	List<Employee> findAll();
}
