package Threads.two;

public class EvenOdd extends Thread{
  private int mod;
  private String message;

  public EvenOdd(int mod, String message) {
    this.mod = mod;
    this.message = message;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 200; i++) {
      if (i % 2 == mod) {
        System.out.print(message.charAt(0));
        Thread.yield();
      }
    }
  }
}