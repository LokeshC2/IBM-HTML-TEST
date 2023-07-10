package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Album extends Object{
  @Column
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int albumId;
  @Column
  private String albumName;
  @Embedded
  private Singer singer;
}
