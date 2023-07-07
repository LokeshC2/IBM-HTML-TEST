package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

  @Column(name = "ac_no")
  @Id
  private int id;

  @Column(name = "ac_name")
  private String name;

  @Column(name = "ac_balance")
  private double balance;

  public Account(String name, double balance) {
    this.name = name;
    this.balance = balance;
  }
}

// SQL:
/*
CREATE TABLE accounts (
  ac_no INT PRIMARY KEY AUTO_INCREMENT,
  ac_name VARCHAR(50) NOT NULL,
  ac_balance DOUBLE NOT NULL
);
 */