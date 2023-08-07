package com.example.departmentservice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  @Query("SELECT d FROM Department d WHERE d.departmentName = ?1")
  Optional<Department> findByDepartmentName(String departmentName);
}