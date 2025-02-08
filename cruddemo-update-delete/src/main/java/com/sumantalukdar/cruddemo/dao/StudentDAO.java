package com.sumantalukdar.cruddemo.dao;

import java.util.List;

import com.sumantalukdar.cruddemo.entity.Student;

public interface StudentDAO {

	void save(Student student);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	List<Student> findByLastName(String theLastName);
	
	  void update(Student theStudent);
	  void delete(Integer id);
}
