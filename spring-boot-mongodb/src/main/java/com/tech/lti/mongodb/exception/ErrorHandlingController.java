package com.tech.lti.mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlingController {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
		
		ErrorResponse errorDetails = new ErrorResponse();
		errorDetails.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.setErrorMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> handleCustomExceptions(CustomException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(ex.getErrorCode());
		errorResponse.setErrorMessage(ex.getErrorMessage());
		errorResponse.setErrorDetails(ex.getErrorDetails());
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> dataNotFoundException(UserNotFoundException ex) {
		
		ErrorResponse errorDetails = new ErrorResponse();
		errorDetails.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorDetails.setErrorMessage(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
