package com.example;

import com.example.service.EmploymentService;
import com.example.service.EmploymentServiceImpl;
import com.example.util.SafeIntegerInput;
import java.util.Scanner;

/**
 * App
 */
public class App {

  static Scanner sc = new Scanner(System.in);
  static SafeIntegerInput safeIntegerInput = new SafeIntegerInput(sc);
  static EmploymentService es = new EmploymentServiceImpl();

  public static void main(String[] args) {
    printHello();
    int menuChoice = 0;
    do {
      System.out.println("Enter 1 for company operations");
      System.out.println("Enter 2 for employee operations");
      System.out.println("Enter 0 to exit");
      menuChoice = safeIntegerInput.get();

      switch (menuChoice) {
        case 1:
          companyMenu();
          break;
        case 2:
          System.out.println("Enter company id: ");
          int companyId = safeIntegerInput.get();
          employeeMenu(companyId);
          break;
        case 0:
          System.out.println(
            "Thank you for using Employment Management System"
          );
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    } while (menuChoice != 0);
  }

  private static void printHello() {
    System.out.println("Welcome to Employment Management System");
  }

  private static void showCompanyMenu() {
    System.out.println("Enter 1 to create a company");
    System.out.println("Enter 2 to get all companies");
    System.out.println("Enter 3 to get a company by id");
    System.out.println("Enter 4 to find a company by name");
    System.out.println("Enter 5 to update a company");
    System.out.println("Enter 6 to delete a company");
    System.out.println("Enter 0 to go back");
  }

  private static void showEmployeeMenu() {
    System.out.println("Enter 1 to create an employee");
    System.out.println("Enter 2 to get all employees");
    System.out.println("Enter 3 to get an employee by id");
    System.out.println("Enter 4 to find an employee by name");
    System.out.println("Enter 5 to update an employee");
    System.out.println("Enter 6 to delete an employee");
    System.out.println("Enter 7 to move an employee to another company");
    System.out.println("Enter 0 to go back");
  }

  private static void companyMenu() {
    int companyMenuChoice = 0;
    int companyId = 0;
    do {
      showCompanyMenu();
      companyMenuChoice = safeIntegerInput.get();
      switch (companyMenuChoice) {
        case 1:
          es.createCompany();
          break;
        case 2:
          es.getAllCompanies();
          break;
        case 3:
          System.out.println("Enter company id: ");
          companyId = safeIntegerInput.get();
          es.getCompanyById(companyId);
          System.out.println("Select this company? (y/n)");
          String choice = sc.nextLine();
          if (choice.equals("y") || choice.equals("Y")) {
            System.out.println("Company selected");
            employeeMenu(companyId);
          } else {
            System.out.println("Company not selected");
          }
          break;
        case 4:
          System.out.println("Enter company name: ");
          String name = sc.nextLine();
          es.findCompanyByName(name);
          break;
        case 5:
          System.out.println("Enter company id: ");
          companyId = safeIntegerInput.get();
          es.updateCompany(companyId);
          break;
        case 6:
          System.out.println("Enter company id: ");
          companyId = safeIntegerInput.get();
          es.deleteCompany(companyId);
          break;
        case 0:
          System.out.println("Going back to main menu");
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    } while (companyMenuChoice != 0);
  }

  private static void employeeMenu(int companyId) {
    int employeeMenuChoice = 0;
    int employeeId = 0;
    do {
      showEmployeeMenu();
      employeeMenuChoice = safeIntegerInput.get();
      switch (employeeMenuChoice) {
        case 1:
          es.createEmployeeInCompany(companyId);
          break;
        case 2:
          es.getAllEmployeesInCompany(companyId);
          break;
        case 3:
          System.out.println("Enter employee id: ");
          employeeId = safeIntegerInput.get();
          es.getEmployeeById(employeeId);
          break;
        case 4:
          System.out.println("Enter employee name: ");
          String name = sc.nextLine();
          es.findEmployeeByName(name);
          break;
        case 5:
          System.out.println("Enter employee id: ");
          employeeId = safeIntegerInput.get();
          es.updateEmployee(employeeId);
          break;
        case 6:
          System.out.println("Enter employee id: ");
          employeeId = safeIntegerInput.get();
          es.deleteEmployee(employeeId);
          break;
        case 7:
          System.out.println("Enter employee id: ");
          employeeId = safeIntegerInput.get();
          System.out.println("Enter new company id: ");
          int newCompanyId = safeIntegerInput.get();
          es.moveEmployeeToCompany(employeeId, newCompanyId);
          break;
        case 0:
          System.out.println("Going back to main menu");
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
    } while (employeeMenuChoice != 0);
  }
}
