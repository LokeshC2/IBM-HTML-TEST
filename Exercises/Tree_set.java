package Exercises;

import java.util.TreeSet;

public class Tree_set {

  public static void main(String[] args) {
    System.out.println("\n\n Tree set\n\n");
 
    // 1. Write a Java program to create a tree set, add some colors (strings) and print out the tree set.
    System.out.println();
    TreeSet<String> treeColors = new TreeSet<String>();
    treeColors.add("Red");
    treeColors.add("Green");
    treeColors.add("Blue");
    treeColors.add("Yellow");
    treeColors.add("Black");
    System.out.println(treeColors);

    // 2. Write a Java program to iterate through all elements in a tree set.
    for (String color : treeColors) {
      System.out.println(color);
    }

    // 3. Write a Java program to add all the elements of a specified tree set to another tree set.
    TreeSet<String> treeColors2 = new TreeSet<String>();
    treeColors2.addAll(treeColors);
    System.out.println(treeColors2);

    // 4. Write a Java program to create a reverse order view of the elements contained in a given tree set.
    System.out.println(treeColors.descendingSet());

    // 5. Write a Java program to get the first and last elements in a tree set.
    System.out.println(treeColors.first());

    // 6. Write a Java program to clone a tree set list to another tree set.
    TreeSet<String> treeColors3 = new TreeSet<String>();
    treeColors3.addAll(treeColors);
    System.out.println(treeColors3);
    
    // 7. Write a Java program to get the number of elements in a tree set.
    System.out.println(treeColors.size());

    // 8. Write a Java program to compare two tree sets.
    System.out.println(treeColors.equals(treeColors2));

    // 9. Write a Java program to find numbers less than 7 in a tree set.
    TreeSet<Integer> treeNumbers = new TreeSet<Integer>();
    treeNumbers.add(1); treeNumbers.add(2); treeNumbers.add(3); treeNumbers.add(4); treeNumbers.add(5); treeNumbers.add(6); treeNumbers.add(7); treeNumbers.add(8); treeNumbers.add(9); treeNumbers.add(10);

    System.out.println(treeNumbers.headSet(7));

    // 10. Write a Java program to get the element in a tree set which is greater than or equal to the given element.
    System.out.println(treeNumbers.ceiling(7));
  }
}
