package com.example.cust_man_sys_rest_2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
  @Id
  private String id;
  private String name;
  @ManyToOne(cascade = CascadeType.ALL)
  private Employee manager;
  @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
  private List<Employee> charges;
  @OneToMany(mappedBy = "relationshipManager")
  private List<Customer> managedCustomers; 
}
