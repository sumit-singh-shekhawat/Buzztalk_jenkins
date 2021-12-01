package com.cg.Buzztalk.exceptionhandling;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
//local exception handler
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex,
	        WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	//Golbal exception handler
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<?> handleAllWrongFormatExceptions(Exception ex,
	        WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(true));
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
