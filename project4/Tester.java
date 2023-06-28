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
    Counter2 counter = new Counter2();
    Counter2 counter2 = new Counter2();
    Counter2 counter3 = new Counter2();
    Counter2 counter4 = new Counter2();
    Counter2 counter5 = new Counter2();
  }

}
