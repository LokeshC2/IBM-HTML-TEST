package com.example.employeeservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Department {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String departmentName;
  @OneToOne
  private Location location;
}
