package com.example;

import java.util.List;

import com.example.models.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

public class App {

  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl();
    List<Employee> e = employeeService.findEmployeeByName("John");
    if (e.isEmpty()) System.out.println("Employee not found");
    else e.forEach(System.out::println);
    System.out.println("All employees:");
    employeeService.getEmployees().forEach(System.out::println); 
  }
}