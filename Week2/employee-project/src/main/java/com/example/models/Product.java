package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @AllArgsConstructor
public class Product {
  private int id;
  private String name;
  private int cost;
  private int quantity;

  public Product(String name, int cost, int quantity) {
    this.name = name;
    this.cost = cost;
    this.quantity = quantity;
  }

}