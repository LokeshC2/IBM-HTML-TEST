package Exercises;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_queue {
  public static void main(String[] args) {
    System.out.println("\n\n Priority Queue\n\n");

    System.out.println("1. Write a Java program to create a priority queue, add some colors (strings) and print out the elements of the priority queue.");
    PriorityQueue<String> queueColors = new PriorityQueue<String>();
    queueColors.add("Red");
    queueColors.add("Green");
    queueColors.add("Blue");
    queueColors.add("Yellow");
    queueColors.add("Black");
    System.out.println(queueColors);

    System.out.println("2. Write a Java program to iterate through all elements in the priority queue.");
    for (String color : queueColors) {
      System.out.println(color);
    }

    System.out.println("3. Write a Java program to add all the elements of a priority queue to another priority queue.");
    PriorityQueue<String> queueColors2 = new PriorityQueue<String>(Comparator.reverseOrder());
    queueColors2.addAll(queueColors);

    System.out.println("4. Write a Java program to insert a given element into a priority queue.");
    queueColors2.add("White");
    System.out.println(queueColors2);

    System.out.println("5. Write a Java program to remove all elements from a priority queue.");
    queueColors2.clear();
    System.out.println(queueColors2);

    System.out.println("6. Write a Java program to count the number of elements in a priority queue.");
    System.out.println(queueColors.size());

    System.out.println("7. Write a Java program to compare two priority queues.");
    System.out.println(queueColors.equals(queueColors2));

    System.out.println("8. Write a Java program to retrieve the first element of the priority queue.");
    System.out.println(queueColors.peek());

    System.out.println("9. Write a Java program to retrieve and remove the first element.");
    System.out.println(queueColors.poll());

    System.out.println("10. Write a Java program to convert a priority queue to an array containing all its elements.");
    String[] arrayColors = queueColors.toArray(new String[queueColors.size()]);
    for (String color : arrayColors) {
      System.out.println(color);
    }
  }
}
