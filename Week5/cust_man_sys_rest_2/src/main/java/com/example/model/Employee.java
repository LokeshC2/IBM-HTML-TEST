package com.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
  @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private String id;
  private String name;
  private Employee manager;
  @OneToMany(mappedBy = "relationshipManager")
  private List<Customer> managedCustomers; 
}
