package com.company.investments.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStatus> handleUserNotFoundException(UserNotFoundException details) {
		ResponseStatus errorStatus = new ResponseStatus();
		errorStatus.setMessage(details.getLocalizedMessage());
		errorStatus.setStatuscode(400);
		return new ResponseEntity<>(errorStatus, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(UserAccountNotFoundException.class)
	public ResponseEntity<ResponseStatus> handleUserAccountNotFoundException(UserAccountNotFoundException details) {
		ResponseStatus errorStatus = new ResponseStatus();
		errorStatus.setMessage(details.getLocalizedMessage());
		errorStatus.setStatuscode(400);
		return new ResponseEntity<>(errorStatus, HttpStatus.BAD_REQUEST);

	}

}
