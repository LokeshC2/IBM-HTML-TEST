package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product {

  @Column(name = "product_id")
  @Id
  private int id;

  @Column(name = "product_name")
  private String name;

  @Column(name = "product_price")
  private double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

}
/*
SQL to create the table:
CREATE TABLE products (
  product_id SERIAL PRIMARY KEY,
  product_name VARCHAR(50),
  product_price DOUBLE PRECISION;
*/
