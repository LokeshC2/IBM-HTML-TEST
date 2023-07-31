package org.example.departmentservice.service;

import org.example.departmentservice.model.Department;
import org.example.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;

	@Override
	public Department findDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
