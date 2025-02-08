package com.sumantalukdar.cruddemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity

@Data
@Table(name="student")
public class Student {

	/*
	 * public Student(int id, String firstName, String lastName, String email) {
	 * super(); this.id = id; this.firstName = firstName; this.lastName = lastName;
	 * this.email = email; }
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",updatable=false)
	private int id;
	@Column(name="firstName",updatable=false)
	private String firstName;
	@Column(name="lastName",updatable=false)
	private String lastName;
	@Column(name="email",updatable=false)
	private String email;

	
	  public Student(String firstName, String lastName, String email) { super();
	  this.firstName = firstName; this.lastName = lastName; this.email = email; }
	 
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
