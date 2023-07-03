package Exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Linked_List {
  public static void main(String[] args) {
    System.out.println("\n\n Linked List\n\n");

    //1: Write a Java program to append the specified element to the end of a linked list.
    System.out.println(1);
    List<String> linkedColors = new ArrayList<String>();
    linkedColors.add("Red");
    linkedColors.add("Green");
    linkedColors.add("Blue");
    System.out.println(linkedColors);

    //2. Write a Java program to iterate through all elements in a linked list.
    System.out.println(2);
    Iterator<String> iterator = linkedColors.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    //3. Write a Java program to iterate through all elements in a linked list starting at the specified position.
    System.out.println(3);
    int start = 1;
    while (iterator.hasNext() && start > 0) {
      System.out.println(iterator.next());
      start--;
    }
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }


    //4. Write a Java program to iterate a linked list in reverse order.
    System.out.println(4);
    LinkedList<String> linkedColors2 = new LinkedList<String>();
    for (int i = linkedColors.size() - 1; i >= 0; i--) {
      linkedColors2.addFirst(linkedColors.get(i));
    }
    System.out.println(linkedColors2);

    //5. Write a Java program to insert the specified element at the specified position in the linked list.
    System.out.println(5);
    linkedColors2.add(1, "Yellow");
    System.out.println(linkedColors2);

    //6. Write a Java program to insert elements into the linked list at the first and last positions.
    System.out.println(6);
    linkedColors2.addFirst("Orange");
    linkedColors2.addLast("Purple");
    System.out.println(linkedColors2);

    //7. Write a Java program to insert the specified element at the front of a linked list.
    System.out.println(7);
    linkedColors2.addFirst("Black");
    System.out.println(linkedColors2);


    //8. Write a Java program to insert the specified element at the end of a linked list.
    System.out.println(8);
    linkedColors2.addLast("White");
    System.out.println(linkedColors2);

    //9. Write a Java program to insert some elements at the specified position into a linked list.
    System.out.println(9);
    linkedColors2.add(1, "Brown");
    System.out.println(linkedColors2);


    //10. Write a Java program to get the first and last occurrence of the specified elements in a linked list.
    System.out.println("10: + \nINdex of Brown First: " + linkedColors2.getFirst() + "\nLast: " + linkedColors2.getLast());
  }
}
