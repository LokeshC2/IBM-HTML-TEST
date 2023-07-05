package com.example;

import com.example.models.Employee;

public class App {

  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl();
    employeeService.addEmployee(
      new Employee("John", "Developer", "1000")
    );
    employeeService.addEmployee(
      new Employee("Jane", "Developer", "1000")
    );

    employeeService.getEmployees().forEach(System.out::println); 
  }
}