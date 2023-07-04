package Threads.two;

public class Tester {
 
  public static void main(String[] args) {
    Thread t1 = new EvenOdd(0, "Even");
    Thread t2 = new EvenOdd(1, "Odd");

    t2.start();
    t1.start();
  }
}