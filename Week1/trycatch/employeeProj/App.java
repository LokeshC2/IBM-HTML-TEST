package trycatch.employeeProj;

import java.io.IOException;

public class App {

  public static void main(String[] args) {
    char choice = '0';
    EmployeeService service = new EmployeeServiceImpl();
    do {
      printMenu();
      try {
        choice = (char) System.in.read();System.in.read();
        switch (choice) {
          case '1':
            System.out.println("Enter name: ");
            String name = System.console().readLine();
            System.out.println("Enter Salary: ");
            Integer Salary = Integer.parseInt(System.console().readLine());
            service.createEmployee(name, Salary);
            break;
          case '2':
            service.listEmployees();
            break;
          case '3':
            System.out.println("Enter ID: ");
            Integer ID = Integer.parseInt(System.console().readLine());
            service.deleteEmployee(ID);
            break;
          case '4':
            System.out.println("Enter ID: ");
            ID = Integer.parseInt(System.console().readLine());
            System.out.println("Enter name: ");
            name = System.console().readLine();
            System.out.println("Enter Salary: ");
            Salary = Integer.parseInt(System.console().readLine());
            service.updateEmployee(ID, name, Salary);
            break;
          case '5':
            System.out.println("Enter name: ");
            name = System.console().readLine();
            System.out.println("Enter Salary: ");
            Salary = Integer.parseInt(System.console().readLine());
            System.out.println("Enter hours worked: ");
            Integer hoursWorked = Integer.parseInt(System.console().readLine());
            service.createContractEmployee(name, Salary, hoursWorked);
            break;
          case '0':
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice");
        }
      } catch (IOException e) {
        System.out.println("Error reading input");
        System.out.println("PLEASE TRY AGAIN");
      }
    } while (choice != '0');
  }
  
  private static void printMenu() {
    System.out.println("1. Create Employee");
    System.out.println("2. List Employees");
    System.out.println("3. Delete Employee");
    System.out.println("4. Update Employee");
    System.out.println("5. Add Contract Employee");
    System.out.println("0. Exit");
  }
}
