package org.example.departmentservice.service;

import org.example.departmentservice.model.Department;

public interface DepartmentService {
	
	Department findDepartmentByName(String departmentName);

}
