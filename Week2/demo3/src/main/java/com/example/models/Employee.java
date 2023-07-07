package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Employee {

  @Column @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int EmployeeId;
  @Column
  private String EmployeeName;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @ToString.Exclude
  private Department department;

  @ToString.Include(name = "department")
  public String getDepartmentName() {
    return department.getDepartmentName();
  }

}
