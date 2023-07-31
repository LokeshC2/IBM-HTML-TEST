package org.example.departmentservice.repository;

import org.example.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query
	Department findByDepartmentName(String departmentName);

}
