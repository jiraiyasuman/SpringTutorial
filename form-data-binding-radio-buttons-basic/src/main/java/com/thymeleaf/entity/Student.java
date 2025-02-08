package com.thymeleaf.entity;

public class Student {

	private String firstName;
	
	private String lastName;

	private String countries;
	
	private String languages;

	private String oS;
	

	public String getoS() {
		return oS;
	}

	public void setoS(String oS) {
		this.oS = oS;
	}
	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
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
