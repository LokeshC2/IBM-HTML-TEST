package com.example.demoMongo.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demoMongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

}
