package org.example.userservice.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class HomeController {
	private static String swaggerPath = "./swagger-ui/";
	
	private final Environment environment;
	
	@GetMapping
	public ResponseEntity<String> redirectToUsers() {
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		return ResponseEntity.ok("Status: this is running on " + port +"<br>" 
				+ "<a href='"+swaggerPath+"'>Swagger UI</a>");
	}
}
