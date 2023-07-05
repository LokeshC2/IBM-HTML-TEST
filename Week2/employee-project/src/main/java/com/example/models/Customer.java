package com.example.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Customer {

  private int id;
  private String fname;
  private String lname;
  private String email;

  public Customer() {}

  public Customer(int id, String fname, String lname, String email) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
  }
}
