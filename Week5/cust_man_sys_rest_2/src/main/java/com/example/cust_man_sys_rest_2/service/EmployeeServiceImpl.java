package com.example.cust_man_sys_rest_2.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.cust_man_sys_rest_2.model.Employee;
import com.example.cust_man_sys_rest_2.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Optional<Employee> getById(String id) {
    return employeeRepository.findById(id);
  }

  @Override
  public Employee createEmployee(Employee employee) {
    String id = UUID.randomUUID().toString();
    employee.setId(id);
    return employeeRepository.save(employee);
  }

  @Override
  public Employee assignCharges(Employee manager, List<Employee> charges) {
    manager.setCharges(charges);
    employeeRepository.flush();
    return manager;
  }
  
}
