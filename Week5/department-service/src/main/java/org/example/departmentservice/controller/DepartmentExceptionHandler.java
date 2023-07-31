package org.example.departmentservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DepartmentExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handler() {
		return ResponseEntity.internalServerError().body("Some Error occured");
	}

}
