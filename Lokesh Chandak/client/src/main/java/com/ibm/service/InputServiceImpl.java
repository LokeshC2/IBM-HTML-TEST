package com.ibm.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class InputServiceImpl implements InputService {

  Scanner scanner = new Scanner(System.in);

  @Override
  public int getPositiveIntChoice(String string) {
    Integer choice = null;
    try {
      System.out.println(string);
      choice = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Invalid choice");
    }
    while (choice == null || choice < 1) {
      try {
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid choice");
      }
    }
    return choice;
  }

  @Override
  public int getIntChoice(String string, List<Integer> validChoices) {
    Integer choice = null;
    choice = Integer.parseInt(scanner.nextLine());
    while (!validChoices.contains(choice)) {
      try {
        choice = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid choice");
      }
      System.out.println("Invalid choice");
      choice = getIntChoice(string, validChoices);
    }
    return choice;
  }

  @Override
  public String getStringChoice(String string, List<String> validChoices) {
    String choice = null;
    choice = scanner.nextLine();
    while (!validChoices.contains(choice)) {
      System.out.println("Invalid choice");
      choice = getStringChoice(string, validChoices);
    }
    return choice;
  }

  @Override
  public void skipLine() {
    scanner.nextLine();
  }

}
