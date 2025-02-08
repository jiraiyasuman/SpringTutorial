package com.sumantalukdar.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sumantalukdar.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class StudentDAOImpl implements StudentDAO{

	// define the field for entityManager
	
	
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	 @Override
	    public List<Student> findByLastName(String theLastName) {
	        // create query
	        TypedQuery<Student> theQuery = entityManager.createQuery(
	                                        "FROM Student WHERE lastName=:theData", Student.class);

	        // set query parameters
	        theQuery.setParameter("theData", theLastName);

	        // return query results
	        return theQuery.getResultList();
	    }
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	public Student findById(Integer id) {
		
		return entityManager.find(Student.class,id);
	}

	@Override
	public List<Student> findAll() {
		// create query
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		return theQuery.getResultList();
	}

	
	

}
