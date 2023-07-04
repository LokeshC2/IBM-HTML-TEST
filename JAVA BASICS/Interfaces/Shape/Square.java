package Interfaces.Shape;

public class Square implements Shape {
  
  private String NAME = "Square";

  private double side;

  public Square(double side) {
    this.side = side;
  }

  @Override
  public double getArea() {
    return side * side;
  }

  @Override
  public String getName() {
    return NAME;
  }

}