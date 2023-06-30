package project4;

public class Tester {

  public static void main(String[] args) {
    testCounter2();
  }

  public static void testCounter() {
    Counter.increment();
    Counter.increment();
    Counter.increment();
    Counter.increment();
    Counter.increment();
    System.out.println(Counter.getCount());
    Counter counter = new Counter();
    counter.decrement();
    counter.decrement();
    counter.decrement();
    System.out.println(Counter.getCount());
    Counter.reset();
    System.out.println(Counter.getCount());
  }

  public static void testCounter2() {
    new Counter2();
    new Counter2();
    new Counter2();
    new Counter2();
    new Counter2();
  }
}
