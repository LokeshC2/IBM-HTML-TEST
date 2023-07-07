package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Shipment {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column
  private String city_name;

  @Column
  private String zip_code;

  @OneToOne(mappedBy = "shipment")
  @ToString.Exclude
  private Order order;
}
