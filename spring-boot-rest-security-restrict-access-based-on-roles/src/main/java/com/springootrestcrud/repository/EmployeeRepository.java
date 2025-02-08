package com.springootrestcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springootrestcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
