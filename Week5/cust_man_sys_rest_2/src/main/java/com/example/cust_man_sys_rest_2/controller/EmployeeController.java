package com.example.cust_man_sys_rest_2.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cust_man_sys_rest_2.model.Employee;
import com.example.cust_man_sys_rest_2.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
 
  private EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<?> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable String id) {
    Optional<?> response = employeeService.getById(id);
    if (response.isEmpty()) {
      return ResponseEntity.status(404).body("No Employee Found!");
    }
    return ResponseEntity.status(200).body(response.get());
  }

  @PostMapping
  public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
    return ResponseEntity.status(200).body(employeeService.createEmployee(employee));
  }

}
