package project4;

public class Counter2 {

  private static int count = 0;

  static
  {
    count++;
    System.out.println("Counter value: " + count);
  }

  Counter2() {
    count++;
    System.out.println("Counter value: " + count);
  }
}