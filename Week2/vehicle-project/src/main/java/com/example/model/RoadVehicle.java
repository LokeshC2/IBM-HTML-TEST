package com.example.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "road_vehicle_table")
@DiscriminatorColumn(
  name = "vehicle_type",
  discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue("road_vehicle")
@NoArgsConstructor
public class RoadVehicle {

  public enum AccelerationType {
    THROTTLE,
    PEDAL,
    LEVER,
  }

  @Id
  @Column(name = "vehicle_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Integer id;

  @Column(name = "making_company")
  protected String make;

  @Column(name = "model_name")
  protected String model;

  @Column(name = "number_of_seats")
  protected static String numCapacity;

  @Column(name = "number_of_wheels")
  protected static String numWheels;
}
