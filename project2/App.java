package project2;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int choice = 0;
    do {
      System.out.println("1. Add employee");
      System.out.println("2. List employees");
      System.out.println("3. Find employee by ID");
      System.out.println("4. Update employee by ID");
      System.out.println("5. Remove employee by Name");
      System.out.println("0. Exit");
      System.out.println("Enter your choice:");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          Employee employee = Employeefactory.createEmployee();
          System.out.println("Employee created: \n" + employee);
          break;
        case 2:
          Employeefactory.listEmployees();
          break;
        case 3:
          System.out.println("Enter employee ID:");
          String id = input.next();
          Employeefactory.findEmployeeById(id);
          break;
        case 4:
          System.out.println("Enter employee ID:");
          id = input.next();
          Employeefactory.updateEmployeeById(id);
          break;
        case 5:
          System.out.println("Enter employee name:");
          String name = input.next();
          Employeefactory.removeAllEmployeesByName(name);
          break;
        case 0:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice!");
          break;
      }
    } while (choice != 0);
    input.close();
  }
}
