package com.springootrestcrud.controller;

public class EmployeeErrorResponse {

	private int status;
	private long timestamp;
	private String message;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public EmployeeErrorResponse(int status, long timestamp, String message) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
	}
	public EmployeeErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
