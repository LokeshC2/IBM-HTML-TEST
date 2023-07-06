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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

  @Column(name = "product_id")
  @Id
  private int id;

  @Column(name = "product_name")
  private String name;

  @Column(name = "product_price")
  private int price;
}
/*
SQL to create the table:
CREATE TABLE products (
  product_id SERIAL PRIMARY KEY,
  product_name VARCHAR(50),
  product_price INT
)
*/
