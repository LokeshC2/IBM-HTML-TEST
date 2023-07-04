package Threads.one;

public class Tester {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new HelloRunner(1));
    Thread t2 = new Thread(new HelloRunner(2));
    Thread t3 = new Thread(new HelloRunner(3));
    Thread t4 = new Thread(new HelloRunner(4));
    
    t4.start();
    t4.join();
    t3.start();
    t2.start();
    t1.start();

  }
}