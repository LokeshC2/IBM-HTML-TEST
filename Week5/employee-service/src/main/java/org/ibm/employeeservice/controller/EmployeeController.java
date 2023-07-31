package org.ibm.employeeservice.controller;

import java.util.List;

import org.ibm.employeeservice.model.EmployeeEntity;
import org.ibm.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
  
  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public List<EmployeeEntity> getEmployees() {
    return employeeService.getEmployees();
  }

  @GetMapping("/{id}")
  public EmployeeEntity getEmployee(@PathVariable("id") int id) {
    return employeeService.getEmployee(id);
  }

  @PostMapping
  public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee) {
    return employeeService.saveEmployee(employee);
  }

  @PutMapping("/{id}")
  public EmployeeEntity updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeEntity employee) {
    return employeeService.updateEmployee(id, employee);
  }

  @DeleteMapping("/{id}")
  public String deleteEmployee(@PathVariable("id") int id) {
    return employeeService.deleteEmployee(id);
  }

}
