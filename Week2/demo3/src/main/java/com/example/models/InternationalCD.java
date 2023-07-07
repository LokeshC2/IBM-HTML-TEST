package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
@lombok.NoArgsConstructor
@Entity
@Table(name = "international_cd")
public class InternationalCD extends CD {

  @Column(name = "cd_language")
  private String language;

  public InternationalCD(String title, String language) {
    super(title);
    this.language = language;
  }
}
