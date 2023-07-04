package Threads.one;

import java.util.Date;

public class HelloRunner implements Runnable {
  private Integer duration;

  HelloRunner(Integer seconds) {
    this.duration = seconds * 1000;
  }

  @Override
  public void run() {
    Date d = new Date();
    Date d2 = new Date();
    while (d2.getTime() - d.getTime() < duration) {
      d2 = new Date();
      System.out.print("\r running thread " + (" ".repeat(duration / 1000)) + (duration / 1000) + "    ");
    }
    System.out.println("\nHello from a thread that ran for " + duration / 1000 + " seconds\n");
  }
}