package com.example.util;

import java.util.Scanner;

public class SafeIntegerInput {
  private static Scanner sc;

  public SafeIntegerInput(Scanner sc) {
    SafeIntegerInput.sc = sc;
  }

  public Integer get() {
    Integer input = null;
    do {
      try {
        input = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number");
      }
    } while (input == null);
    return input;
  }
}
