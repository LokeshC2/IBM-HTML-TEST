package com.example.demoMongo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demoMongo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	@Override
	public List<Student> list() {
		return 
	}

	@Override
	public Student create() {
		// TODO Auto-generated method stub
		return null;
	}

}
