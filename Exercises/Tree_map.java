package Exercises;

import java.util.Comparator;
import java.util.TreeMap;

public class Tree_map {

  public static void main(String[] args) {
    System.out.println("\n\n Tree Map\n\n");

    System.out.println("1. Write a Java program to associate the specified value with the specified key in a TreeMap.");
    TreeMap < Integer, String > map = new TreeMap < Integer, String > ();
    map.put(1, "Red");
    map.put(2, "Green");
    map.put(3, "Blue");
    map.put(4, "Yellow");
    System.out.println(map);

    System.out.println("2. Write a Java program to copy a Tree Map content to another Tree Map.");
    TreeMap < Integer, String > map2 = new TreeMap < Integer, String > ();
    map2.putAll(map);

    System.out.println("3. Write a Java program to search a key in a Tree Map.");
    System.out.println(map2.containsKey(1));

    System.out.println("4. Write a Java program to search a value in a Tree Map.");
    System.out.println(map2.containsValue("Red"));

    System.out.println("5. Write a Java program to get all keys from the given a Tree Map.");
    System.out.println(map2.keySet());

    System.out.println("6. Write a Java program to delete all elements from a given Tree Map.");
    map2.clear();

    System.out.println("7. Write a Java program to sort keys in Tree Map by using comparator.");
    TreeMap < Integer, String > map3 = new TreeMap < Integer, String > (Comparator.reverseOrder());
    map3.put(1, "Red");
    map3.put(2, "Green");
    map3.put(3, "Blue");
    map3.put(4, "Yellow");

    System.out.println("8. Write a Java program to get a key-value mapping associated with the greatest key and the least key in a map.");

    System.out.println("9. Write a Java program to get the first (lowest) key and the last (highest) key currently in a map.");

    System.out.println("10. Write a Java program to get a reverse order view of the keys contained in a given map.");

  }
}