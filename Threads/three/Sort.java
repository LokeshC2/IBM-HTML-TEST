package Threads.three;

public class Sort implements Runnable {

  private int[] array;
  private int si;

  public Sort(int[] array, int si) {
    this.array = array;
    this.si = si;
  }

  @Override
  public void run() {
    if (array.length == 2) sort2();
    else if (array.length > 2) mergesort();
    else System.out.println("Sorted  " + "  ".repeat(si) + array[0]);
  }

  private void mergesort() {
    int mid = array.length / 2;
    int[] a1 = new int[mid];
    for (int i = 0; i < mid; i++) {
      a1[i] = array[i];
    }
    int[] a2 = new int[array.length - mid];
    for (int i = mid; i < array.length; i++) {
      a2[i - mid] = array[i];
    }
    Sort s1 = new Sort(a1, si);
    Sort s2 = new Sort(a2, si + a1.length);
    Thread t1 = new Thread(s1);
    Thread t2 = new Thread(s2);
    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    a1 = s1.getArray();
    a2 = s2.getArray();

    merge(a1, a2);
  }

  private void merge(int[] a1, int[] a2) {
    array = new int[a1.length + a2.length];
    int i = 0, j = 0, k = 0;
    while (i < a1.length && j < a2.length) {
      if (a1[i] < a2[j]) {
        array[k++] = a1[i++];
      } else {
        array[k++] = a2[j++];
      }
    }
    while (i < a1.length) {
      array[k++] = a1[i++];
    }
    while (j < a2.length) {
      array[k++] = a2[j++];
    }
    
    String s = "Merged  " + "  ".repeat(si);
    for (i = 0; i < array.length; i++) {
      s += array[i] + " ";
    }
    System.out.println(s);

  }

  private void sort2() {
    if (array[0] > array[1]) {
      int temp = array[0];
      array[0] = array[1];
      array[1] = temp;
    }
    String s = "Sorted  " + "  ".repeat(si);
    for (int i = 0; i < array.length; i++) {
      s += array[i] + " ";
    }
    System.out.println(s);
  }

  public int[] getArray() {
    return array;
  }
}
