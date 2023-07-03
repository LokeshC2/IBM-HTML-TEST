package Exercises;

import java.util.ArrayList;

public class Array_list {

  public static void main(String[] args) {
    // 1: Create Array List and print collection
    System.out.println(1);
    ArrayList<String> colors = new ArrayList<String>();
    colors.add("Red");
    colors.add("Green");
    colors.add("Blue");
    System.out.println(colors);

    // 2: Iterate through ArrayList using for loop
    System.out.println(2);
    for (int i = 0; i < colors.size(); i++) {
      System.out.println(colors.get(i));
    }

    // 3: Insert an element into the ArrayList at the first position
    System.out.println(3);
    colors.add(0, "Yellow");
    System.out.println(colors);

    // 4: Retrieve an element (at a specified index) from a given ArrayList
    System.out.println(4);
    System.out.println(colors.get(0));

    // 5: Update specific array element by given element
    System.out.println(5);
    colors.set(0, "Orange");
    System.out.println(colors);

    // 6. Write a Java program to remove the third element from an array list.
    System.out.println(6);
    colors.remove(2);
    System.out.println(colors);

    // 7. Write a Java program to search for an element in an array list.
    System.out.println("7: " + colors.contains("Orange"));

    // 8. Write a Java program to sort a given array list.
    colors.sort(null);
    System.out.println("8: " + colors);

    // 9. Write a Java program to copy one array list into another.
    ArrayList<String> colors2 = new ArrayList<String>();
    colors2.addAll(colors);
    System.out.println("9: " + colors + colors2);

    // 10. Write a Java program to shuffle elements in an array list.
    for (int i = 0; i < colors.size(); i++) {
      for (int j = 0; j < colors.size(); j++) {
        if (i != j) {
          String temp = colors.get(i);
          colors.set(i, colors.get(j));
          colors.set(j, temp);
        }
      }
    }
    System.out.println("10: " + colors);
  }
}
