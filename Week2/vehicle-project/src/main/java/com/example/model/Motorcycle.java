package com.example.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="motorcycle_table")
@DiscriminatorValue("motorcycle")
@NoArgsConstructor
public class Motorcycle extends RoadVehicle {
  @Enumerated(EnumType.STRING)
  private final AccelerationType accelerationType = AccelerationType.THROTTLE;

  public Motorcycle(String make, String model) {
    super();
    numWheels = "2";
    numCapacity = "2";
    this.make = make;
    this.model = model;
  }
}
