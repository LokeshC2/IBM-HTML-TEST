package com.example.demoMongo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMongo.model.Student;
import com.example.demoMongo.service.StudentService;

@RestController
public class StudentController {
	
	private StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> getAll(){
		return ResponseEntity.ok(studentService.list());
	}
	
	@PostMapping
	public ResponseEntity<Student> create() {
		return ResponseEntity.ok(studentService.create());
	}
}
