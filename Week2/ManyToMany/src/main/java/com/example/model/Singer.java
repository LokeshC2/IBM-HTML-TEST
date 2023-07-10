package com.example.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Embeddable
@Data
public class Singer {
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int singerId;
  private String singerName;
  private String singerCountry;
}
