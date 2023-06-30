package Interfaces.Shape;

public class Rectangle implements Shape {

  private String NAME = "Rectangle";

  private double length;
  private double breadth;

  public Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  @Override
  public double getArea() {
    return length * breadth;
  }

  @Override
  public String getName() {
    return NAME;
  }

}