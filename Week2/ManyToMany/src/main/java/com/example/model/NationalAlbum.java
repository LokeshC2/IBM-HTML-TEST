package com.example.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class NationalAlbum extends Album {
  private String albumPrice;

  @Override
  public String toString() {
    return "NationalAlbum [" + super.toString() + ", albumPrice=" + albumPrice + "]";
  }
}
