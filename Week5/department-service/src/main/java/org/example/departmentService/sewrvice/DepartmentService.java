package org.example.departmentService.sewrvice;

import org.example.departmentService.model.Department;

public interface DepartmentService {
	
	Department findDepartmentByName(String departmentName);

}
