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
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Entity
@Table(name = "inventory")
@ToString
public class Inventory {

  @Column(name = "inventory_id")
  @Id
  private int id;

  @Column(name = "product_id")
  private int product_id;

  @Column(name = "product_name")
  private String name;

  @Column(name = "product_count")
  private int quantity;
}

/* 
SQL to create the table:
CREATE TABLE inventory (
  inventory_id SERIAL PRIMARY KEY,
  product_id INT,
  product_name VARCHAR(50),
  product_count INT 
);
*/