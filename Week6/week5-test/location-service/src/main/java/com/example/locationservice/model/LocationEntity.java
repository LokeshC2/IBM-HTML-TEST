package com.example.locationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "locations")
public class LocationEntity {

  @Id
  private String id;
  private Location location;

}
