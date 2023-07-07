package com.example.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Department {
  @Column @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int departmentId;

  @Column
  private String departmentName;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @ToString.Exclude
  private List<Employee> employees = new ArrayList<Employee>();

  public void addEmployee(Employee employee) {
    employees.add(employee);
    employee.setDepartment(this);
  }

  @ToString.Include(name = "employees")
  public int getEmployeeCount() {
    return employees.size();
  }
}
