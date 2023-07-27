package com.example.cust_man_sys_rest_2.service;

import java.util.List;
import java.util.Optional;

import com.example.cust_man_sys_rest_2.model.Employee;

public interface EmployeeService {

  List<Employee> getAll();

  Optional<Employee> getById(String id);

  Employee createEmployee(Employee employee);

  Employee assignCharges(Employee manager, List<Employee> charges);
}
