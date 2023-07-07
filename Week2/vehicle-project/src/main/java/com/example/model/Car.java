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
@DiscriminatorValue("car")
@Table(name = "car_table")
@NoArgsConstructor
public class Car extends RoadVehicle {
  @Enumerated(EnumType.STRING)
  private final AccelerationType accelerationType = AccelerationType.PEDAL;

  public Car(String make, String model) {
    super();
    numWheels = "4";
    numCapacity = "5";
    this.make = make;
    this.model = model;
  }
}
