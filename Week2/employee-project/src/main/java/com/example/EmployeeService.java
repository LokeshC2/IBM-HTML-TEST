package com.example;

import java.util.List;

import com.example.models.Employee;

public interface EmployeeService {
  public void addEmployee(Employee employee);
  public List<Employee> getEmployees();
  public List<Employee> findEmployeeByName(String name);
}