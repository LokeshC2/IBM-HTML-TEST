package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.ToString
@lombok.NoArgsConstructor
@Entity
@Table(name = "cd")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CD {

  @Column(name = "cd_id")
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  protected int id;

  @Column(name = "cd_name")
  protected String name;

  public CD(String name) {
    this.name = name;
  }

}
