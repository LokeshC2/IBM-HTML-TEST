package com.example.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class InternationalAlbum extends Album {
  private String albumLanguage;
  private String albumPrice;
  
  public String toString() {
    return "InternationalAlbum [" + super.toString() + ", albumLanguage=" + albumLanguage + ", albumPrice=" + albumPrice + "]";
  }
}
