package com.thymeleaf.entity;

public class Student {

	private String firstName;
	
	private String lastName;

	private String countries;
	
	

	

	public Student(String firstName, String lastName, String countries) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.countries = countries;
	}

	public String getCountries() {
		return countries;
	}

	public void setCountries(String countries) {
		this.countries = countries;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
