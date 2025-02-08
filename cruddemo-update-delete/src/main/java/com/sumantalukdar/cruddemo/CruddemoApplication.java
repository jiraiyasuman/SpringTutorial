package com.sumantalukdar.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sumantalukdar.cruddemo.dao.StudentDAO;
import com.sumantalukdar.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
			//createStudent(studentDAO);
		//	queryForStudents(studentDAO);
		//	createMultipleStudents(studentDAO);
		//	queryForStudents(studentDAO);
		//	queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);

			deleteStudent(studentDAO);
		};
	}
	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 2;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "John"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}
	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Create the new student objects");
		Student tempStudent = new Student("Suman","Talukdar","suman@gmail.com");
		// save the student object
		
		System.out.println("Saving the java object");
		studentDAO.save(tempStudent);
		// display the student id object
		//System.out.println("Saved student. Generated ID: "+tempStudent.getId());
	}
	private void queryForStudents(StudentDAO studentDAO) {
		// get a list of all data
		List<Student> theStudents=studentDAO.findAll();
		// displaying the Students
		for(Student students : theStudents) {
			System.out.println(students);
		}
	}
	
	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Create the new student objects");
		Student student = new Student("Daffy","Disney","daffy@gmail.com");
		// save the student
		System.out.println("Saving the object");
		studentDAO.save(student);
		// display the id of the object
		int id = student.getId();
		System.out.println();
		System.out.println("Saved student. Generated id: " + id);
		// retrieve student based on the id: primary key
				System.out.println("Retrieving student with id: " + id);
				Student myStudent = studentDAO.findById(id);
				// display student
				System.out.println("Found the student: " + myStudent);
	}
	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
}
