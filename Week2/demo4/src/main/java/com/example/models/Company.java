package com.example.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employees")
public class Company {
  @Column(name = "company_id")
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "company_name")
  private String name;
  @Column(name = "company_address")
  @Embedded
  private Address address;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
  private List<Employee> employees;
}
