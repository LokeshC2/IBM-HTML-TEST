package org.ibm.employeeservice.service;

import java.util.List;

import org.ibm.employeeservice.model.EmployeeEntity;
import org.ibm.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<EmployeeEntity> getEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public EmployeeEntity getEmployee(int id) {
    return employeeRepository.findById(id).orElse(null);
  }

  @Override
  public EmployeeEntity saveEmployee(EmployeeEntity employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public EmployeeEntity updateEmployee(int id, EmployeeEntity employee) {
    EmployeeEntity existingEmployee = employeeRepository.findById(id).orElse(null);
    existingEmployee.setEmployeeName(employee.getEmployeeName());
    existingEmployee.setDepartmentId(employee.getDepartmentId());
    existingEmployee.setDepartmentName(employee.getDepartmentName());
    existingEmployee.setLocation(employee.getLocation());
    return employeeRepository.save(existingEmployee);
  }

  @Override
  public String deleteEmployee(int id) {
    employeeRepository.deleteById(id);
    return "Employee deleted with id: " + id;
  }
}
