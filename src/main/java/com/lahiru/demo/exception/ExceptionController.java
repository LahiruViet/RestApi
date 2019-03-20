package com.lahiru.demo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleException(Exception exception, HttpServletRequest request, HttpServletResponse response){
		
		Error error = new Error(response.getStatus(), exception.getMessage(), request.getRequestURL().toString());
		return ResponseEntity.status(response.getStatus()).body(error);	
	}
}
