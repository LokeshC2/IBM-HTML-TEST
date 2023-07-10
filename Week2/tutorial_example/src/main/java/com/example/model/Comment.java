package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 

import lombok.Data;

@Entity
@Data
public class Comment {
  @Column @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column
  private String content;
  @ManyToOne
  @JoinColumn(name = "tutorial_id")
  private Tutorial tutorial;
}
