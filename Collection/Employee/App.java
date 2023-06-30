package Collection.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    EmployeeService empService;
    System.out.println("Welcome to the Employee App");
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter 1 for ArrayList, 2 for HashSet");
    int listOrSet = sc.nextInt(); sc.nextLine();

    if (listOrSet == 1) {
      empService =
        new EmpServiceImpl<ArrayList<Employee>>(new ArrayList<Employee>());
      mainMenu(sc, empService);
    } else if (listOrSet == 2) {
      empService =
        new EmpServiceImpl<HashSet<Employee>>(new HashSet<Employee>());
      mainMenu(sc, empService);
    } else {
      System.out.println("Invalid choice");
    }

    System.out.println("Thank you for using the Employee App");
    sc.close();
  }

  public static void mainMenu(Scanner sc, EmployeeService empService) {
    int choice = 0;
    do {
      printMainMenu();
      choice = sc.nextInt(); sc.nextLine();
      switch (choice) {
        case 0:
          System.out.println("Exiting the application");
          break;
        case 1:
          System.out.println("Enter employee id: ");
          String id = sc.nextLine();
          System.out.println("Enter employee first name: ");
          String firstName = sc.nextLine();
          System.out.println("Enter employee last name: ");
          String lastName = sc.nextLine();
          System.out.println("Enter employee email: ");
          String email = sc.nextLine();
          empService.addEmployee(id, firstName, lastName, email);
          break;
        case 2:
          System.out.println("Enter employee id: ");
          id = sc.nextLine();
          Employee emp = empService.findEmployee(id);
          System.out.println(emp);
          break;
        case 3:
          System.out.println("Enter employee id: ");
          id = sc.nextLine();
          System.out.println(
            "Enter new employee first name (or press enter to skip): "
          );
          firstName = sc.nextLine();
          System.out.println(
            "Enter new employee last name (or press enter to skip): "
          );
          lastName = sc.nextLine();
          System.out.println(
            "Enter new employee email (or press enter to skip): "
          );
          email = sc.nextLine();
          empService.updateEmployee(id, firstName, lastName, email);
          break;
        case 4:
          System.out.println("Enter employee id: ");
          id = sc.nextLine();
          empService.deleteEmployee(id);
          break;
        case 5:
          empService.viewAllEmployees();
          break;
        default:
          System.out.println("Invalid choice, please try again");
      }
    } while (choice != 0);
  }

  private static void printMainMenu() {
    System.out.println("Main Menu");
    System.out.println("---------");
    System.out.println("1. Add Employee");
    System.out.println("2. Find Employee");
    System.out.println("3. Update Employee");
    System.out.println("4. Delete Employee");
    System.out.println("5. View All Employees");
    System.out.println("0. Exit");
    System.out.println("Enter your choice (0-4): ");
  }
}
