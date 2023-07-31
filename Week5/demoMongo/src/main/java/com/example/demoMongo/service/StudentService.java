package com.example.demoMongo.service;

import java.util.List;

import com.example.demoMongo.model.Student;

public interface StudentService {

	List<Student> list();

	Student create();
}
