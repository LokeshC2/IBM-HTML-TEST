package org.example.userservice.controller;

import org.example.userservice.exception.InvalidCredentialsExcetion;
import org.example.userservice.exception.UserNotFoundException;
import org.example.userservice.ui.ErrorResponseModel;
import org.springframework.http.HttpStatus;
// import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
// @RequiredArgsConstructor
@RestControllerAdvice
public class HomeController {
	// private static String swaggerPath = "./swagger-ui/";
	
	// private final Environment environment;
	
	// @GetMapping
	// public ResponseEntity<String> redirectToUsers() {
		// int port = Integer.parseInt(environment.getProperty("local.server.port"));
		// return ResponseEntity.ok("Status: this is running on " + port +"<br>" 
				// + "<a href='"+swaggerPath+"'>Swagger UI</a>");
	// }

	@GetMapping("/status")
	public ResponseEntity<String> status() {
		return ResponseEntity.ok("Status: OK");
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(UserNotFoundException ex) {
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		errorResponseModel.setErrorMessage(ex.getMessage());
		errorResponseModel.setErrorResponseTime(String.valueOf(System.currentTimeMillis()));
		errorResponseModel.setStatus(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);
	}

	@ExceptionHandler(InvalidCredentialsExcetion.class)
	public ResponseEntity<ErrorResponseModel> handleInvalidCredentialsException(InvalidCredentialsExcetion ex) {
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		errorResponseModel.setErrorMessage(ex.getMessage());
		errorResponseModel.setErrorResponseTime(String.valueOf(System.currentTimeMillis()));
		errorResponseModel.setStatus(HttpStatus.UNAUTHORIZED.value());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponseModel);
	}
}
