package com.tech.lti.mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex) throws Exception {
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> dataNotFoundException(UserNotFoundException ex) throws Exception {
		
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setCode(HttpStatus.NOT_FOUND.value());
		errorDetails.setMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
