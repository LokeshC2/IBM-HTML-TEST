package project3.model;

public class equalsOverloading {
  public static void main(String[] args) {
    MyDate d1 = new MyDate(1, 1, 2000);
    MyDate d2 = new MyDate(1, 1, 2000);
    MyDate d3 = new MyDate(1, 1, 2001);
    System.out.println("d1.equals(d2): " + d1.equals(d2));
    System.out.println("d1.equals(d3): " + d1.equals(d3));
  }
  
}