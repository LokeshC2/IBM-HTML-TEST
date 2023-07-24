package com.ibm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="stock_orders")
public class Order {
  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  private int orderNo;
  private String action;
  private int qunatity;
  private double amount;
  private double commission;
  private double totalAmount;
  private String symbol;

  public Order(int orderNo, Stock stock, String action, int quantity, Double amount, Double commission, Double totalAmount) {
    this.orderNo = orderNo;
    this.symbol = stock.getSymbol();
    this.action = action;
    this.qunatity = quantity;
    this.amount = amount;
    this.commission = commission;
    this.totalAmount = totalAmount;
  }

}
