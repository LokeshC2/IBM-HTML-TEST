package Interfaces.Shape;

public class Tester {
  public static void main(String[] args) {
    Shape[] shapes = new Shape[3];
    shapes[0] = new Circle(5);
    shapes[1] = new Rectangle(5, 10);
    shapes[2] = new Square(5);

    for (Shape shape : shapes) {
      System.out.println(shape.getName() + " area: " + shape.getArea());
    }
  }
}
