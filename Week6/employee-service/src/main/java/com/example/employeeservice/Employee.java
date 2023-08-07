package com.example.employeeservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  public String firstName;
  public String lastName;
  public String email;
  public String department;
}
