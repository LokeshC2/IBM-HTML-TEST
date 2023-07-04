package Exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Hash_set {
  public static void main(String[] args) {
    System.out.println("\n\n Hashset\n\n");

    // 1. Write a Java program to append the specified element to the end of a hash set.
    System.out.println(1);
    HashSet<String> hashColors = new HashSet<String>();
    hashColors.add("Red");
    hashColors.add("Green");
    hashColors.add("Blue");

    // 2. Write a Java program to iterate through all elements in a hash list.
    System.out.println(2);
    Iterator<String> iterator2 = hashColors.iterator();
    while (iterator2.hasNext()) {
      System.out.println(iterator2.next());
    }

    // 3. Write a Java program to get the number of elements in a hash set.
    System.out.println(3);
    System.out.println(hashColors.size());    

    // 4. Write a Java program to empty an hash set.
    System.out.println(4);
    hashColors.clear();
    System.out.println(hashColors);

    // 5. Write a Java program to test if a hash set is empty or not.
    System.out.println(5);
    System.out.println(hashColors.isEmpty());

    // 6. Write a Java program to clone a hash set to another hash set.
    System.out.println(6);
    HashSet<String> hashColors2 = new HashSet<String>();
    hashColors2.addAll(hashColors);

    // 7. Write a Java program to convert a hash set to an array.
    System.out.println(7);
    String[] hashColorsArray = new String[hashColors.size()];
    hashColors.toArray(hashColorsArray);
    System.out.println(hashColorsArray);


    // 8. Write a Java program to convert a hash set to a tree set.
    System.out.println(8);
    TreeSet<String> treeColors = new TreeSet<String>();
    treeColors.addAll(hashColors);
    System.out.println(treeColors);
    


    // 9. Write a Java program to find numbers less than 7 in a tree set.
    System.out.println(9);
    TreeSet<Integer> treeNumbers = new TreeSet<Integer>();
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    treeNumbers.addAll(Arrays.asList(numbers));
    System.out.println(treeNumbers.headSet(7));

    // 10. Write a Java program to compare two hash set.
    System.out.println(10);
    System.out.println(hashColors.equals(hashColors2));
  }
}
