package com.example.springApp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  private int id;
  @Value("${employee.name}")
  private String name;
  @Autowired
  private Department department;
  @Value("${employee.salary}")
  private int salary;
}
