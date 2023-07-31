package org.example.departmentService.sewrvice;

import org.example.departmentService.model.Department;
import org.example.departmentService.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;

	@Override
	public Department findDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
