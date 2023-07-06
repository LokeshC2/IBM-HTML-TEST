package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class Order {
  private int id;
  private int productId;
  private int quantity;
  private int totalCost;  
}
