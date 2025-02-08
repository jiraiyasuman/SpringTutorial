package com.springootrestcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class EmployeeExceptionHandler {

	// catch an exception handler using @ExceptionHandler
		@ExceptionHandler
		public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){
			EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
			errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
			errorResponse.setMessage(exc.getMessage());
			errorResponse.setTimestamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		}
		// add another exception handler ... to catch any exception (catch all)
		@ExceptionHandler
		public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc){
			// create a StudentResponse
			
			EmployeeErrorResponse error = new EmployeeErrorResponse();
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimestamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
			
		}
}
