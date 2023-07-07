package com.example.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {

  @Column(name="order_id")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int orderId;

  @Column
  private String orderName;

  @OneToOne(cascade = CascadeType.PERSIST)
  private Shipment shipment;
}

