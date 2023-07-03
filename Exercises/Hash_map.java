package Exercises;

import java.util.HashMap;

public class Hash_map {
  public static void main(String[] args) {
    System.out.println("\n\n Hashmap\n\n");

    System.out.println("1. Write a Java program to associate the specified value with the specified key in a HashMap.");
    HashMap<Integer, String> map = new HashMap<Integer, String>();
    map.put(1, "Red");
    map.put(2, "Green");
    map.put(3, "Blue");
    map.put(4, "Yellow");
    map.put(5, "Black");

    System.out.println("2. Write a Java program to count the number of key-value (size) mappings in a map.");
    System.out.println(map.size());

    System.out.println("3. Write a Java program to copy all mappings from the specified map to another map.");
    HashMap<Integer, String> map2 = new HashMap<Integer, String>(map);
    System.out.println(map2);

    System.out.println("4. Write a Java program to remove all mappings from a map.");
    map2.clear();

    System.out.println("5. Write a Java program to check whether a map contains key-value mappings (empty) or not.");
    System.out.println(map2.isEmpty());

    System.out.println("6. Write a Java program to get a shallow copy of a HashMap instance.");
    HashMap<Integer, String> map3 = new HashMap<Integer, String>();
    map3 = (HashMap)map.clone();
    System.out.println(map3);

    System.out.println("7. Write a Java program to test if a map contains a mapping for the specified key.");
    System.out.println(map.containsKey(1));

    System.out.println("8. Write a Java program to test if a map contains a mapping for the specified value.");
    System.out.println(map.containsValue("Red"));

    System.out.println("9. Write a Java program to create a set view of the mappings contained in a map.");
    System.out.println(map.entrySet());

    System.out.println("10. Write a Java program to get the value of a specified key in a map.");
    System.out.println(map.get(1));
  }
}
