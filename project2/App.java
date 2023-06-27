package project2;

import java.util.Scanner;
import java.util.Vector;

public class App {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Vector<Employee> employees = new Vector<Employee>();
    int choice = 0;
    do {
      System.out.println("1. Add employee");
      System.out.println("2. List employees");
      System.out.println("3. Find employee by ID");
      System.out.println("0. Exit");
      System.out.println("Enter your choice:");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          employees.add(Employeefactory.createEmployee());
          break;
        case 2:
          for (Employee employee : employees) {
            System.out.println(employee);
          }
          break;
        case 3:
          System.out.println("Enter employee ID:");
          String id = input.next();
          for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(id)) {
              System.out.println(employee);
              break;
            }
          }
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
