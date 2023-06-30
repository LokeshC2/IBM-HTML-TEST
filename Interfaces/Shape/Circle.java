package Interfaces.Shape;

public class Circle implements Shape {

  private String NAME = "Circle";

  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public String getName() {
    return NAME;
  }

}