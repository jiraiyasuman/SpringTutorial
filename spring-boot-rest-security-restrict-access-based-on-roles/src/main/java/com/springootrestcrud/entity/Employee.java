package com.springootrestcrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="employee")
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private int id;
	@Column(name="first_name",nullable=false)
	private String firstName;
	@Column(name="last_name",nullable=false)
	private String lastName;
	@Column(name="email",nullable = false)
	private String email;
	public Employee(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
