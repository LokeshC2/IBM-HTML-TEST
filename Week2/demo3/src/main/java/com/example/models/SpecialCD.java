package com.example.models;

@lombok.Getter
@lombok.Setter
@lombok.ToString(callSuper = true)
@lombok.NoArgsConstructor
@javax.persistence.Entity
@javax.persistence.Table(name = "special_cd")
public class SpecialCD extends CD {

  private String specialFeature;

  public SpecialCD(String title, String specialFeature) {
    super(title);
    this.specialFeature = specialFeature;
  }
}
