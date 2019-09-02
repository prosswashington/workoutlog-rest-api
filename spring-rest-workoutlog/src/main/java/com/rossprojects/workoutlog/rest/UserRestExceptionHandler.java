package com.rossprojects.workoutlog.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {
		
		// create CustomErrorResponse
		
		UserErrorResponse error = new UserErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
				
		// return ResponseEntity
		
		return new ResponseEntity<> (error, HttpStatus.NOT_FOUND);
	}
	// Add another exception ... to catch any exception (catch all)
	
	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception exc) {
		
		// create CustomErrorResponse
		
		UserErrorResponse error = new UserErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
				
		// return ResponseEntity
		
		return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
	}
}