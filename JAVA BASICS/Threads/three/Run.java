package Threads.three;

public class Run {
  public static void main(String[] args) {
    int size = 32;
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = (int) (Math.random() * 10);
    }
    System.out.print("Sorting ");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
    Sort s = new Sort(array, 0);
    Thread t = new Thread(s);
    long start = System.currentTimeMillis();
    t.start();
    try {
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    long end = System.currentTimeMillis();
    array = s.getArray();
    System.out.println("Time taken: " + (end - start) + "ms");
    for (int i = 0; i < size; i++) {
      System.out.print(array[i] + " ");
    }
  }
}
