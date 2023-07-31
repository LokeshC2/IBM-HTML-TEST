package org.ibm.employeeservice.service;

import java.util.List;

import org.ibm.employeeservice.model.EmployeeEntity;

public interface EmployeeService {

  List<EmployeeEntity> getEmployees();

  EmployeeEntity getEmployee(int id);

  EmployeeEntity saveEmployee(EmployeeEntity employee);

  EmployeeEntity updateEmployee(int id, EmployeeEntity employee);

  String deleteEmployee(int id);

}
