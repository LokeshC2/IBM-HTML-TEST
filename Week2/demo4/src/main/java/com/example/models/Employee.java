package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  @Column(name = "employee_id")
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "employee_name")
  private String name;
  @Column(name = "employee_address")
  @Embedded
  private Address address;
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id")
  @ToString.Exclude
  private Company company;

  @ToString.Include(name = "company")
  public String getCompanyName() {
    return company.getName();
  }
}
