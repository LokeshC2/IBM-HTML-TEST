package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.ToString
public class Course {
  @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
  private int id;
  @Column(name = "course_name")
  private String name;
  @Column(name = "course_price")
  private double price;

  public Course(String name, double price) {
    this.name = name;
    this.price = price;
  }
}