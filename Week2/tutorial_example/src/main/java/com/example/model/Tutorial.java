package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Tutorial {
  @Column
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column
  private String title;
  @Column
  private String description;
  @Column
  private Boolean published;
  @OneToMany(mappedBy = "tutorial")
  private List<Comment> comments;
}
