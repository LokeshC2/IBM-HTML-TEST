package com.example;

import java.util.Scanner;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

public class App {
  private static CustomerService customerService = new CustomerServiceImpl();
  public static void main(String[] args) {
    
    System.out.println("Welcome to the shop!");
    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    do {
      printMenu();
      choice = Integer.parseInt(scanner.nextLine());
      switch (choice) {
        case 1:
          addCustomer(scanner);
          break;
        case 2:
          deleteCustomer(scanner);
          break;
        case 3:
          customerService.getAllCustomers();
          break;
        case 4:
          getCustomersByFname(scanner);
          break;
        case 5:
          getCustomer(scanner);
          break;
        case 6:
          updateCustomer(scanner);
          break;
        case 7:
          customerService.deleteAllCustomers();
          break;
        case 8:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice");
      }
    } while (choice != 7);
    
    scanner.close();
    System.out.println("Goodbye!");
  }

  
  public static void printMenu() {
    System.out.println("1. Add customer");
    System.out.println("2. Delete customer");
    System.out.println("3. Get all customers");
    System.out.println("4. Get customers by first name");
    System.out.println("5. Get customer by id");
    System.out.println("6. Update customer");
    System.out.println("7. Delete all customers");
    System.out.println("8. Exit");
    System.out.println("Enter choice: ");
  }

  private static void addCustomer(Scanner scanner) {
    System.out.println("Enter first name: ");
    String fname = scanner.nextLine();
    System.out.println("Enter last name: ");
    String lname = scanner.nextLine();
    System.out.println("Enter email: ");
    String email = scanner.nextLine();
    customerService.addCustomer(fname, lname, email);
  }
  
  private static void deleteCustomer(Scanner scanner) {
    System.out.println("Enter customer id: ");
    int id = Integer.parseInt(scanner.nextLine());
    customerService.deleteCustomer(id);
  }

  private static void getCustomersByFname(Scanner scanner) {
    System.out.println("Enter first name: ");
    String fname = scanner.nextLine();
    customerService.getCustomersByFname(fname);
  }

  private static void getCustomer(Scanner scanner) {
    System.out.println("Enter customer id: ");
    int id = Integer.parseInt(scanner.nextLine());
    customerService.getCustomer(id);
  }

  private static void updateCustomer(Scanner scanner) {
    System.out.println("Enter customer id: ");
    int id = Integer.parseInt(scanner.nextLine());
    System.out.println("Enter new first name: (leave blank to keep current)");
    String fname = scanner.nextLine();
    System.out.println("Enter new last name: (leave blank to keep current)");
    String lname = scanner.nextLine();
    System.out.println("Enter new email: (leave blank to keep current)");
    String email = scanner.nextLine();
    customerService.updateCustomer(id, fname, lname, email); 
  }
}

