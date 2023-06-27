package project2;

import java.util.Scanner;
import java.util.Vector;

public class Employeefactory {

  static Scanner input = new Scanner(System.in);
  static Vector<Employee> employees = new Vector<Employee>();

  public static Employee createEmployee() {
    System.out.println("Enter employee name:");
    String name = input.nextLine();
    System.out.println("Enter employee salary:");
    Integer salary = Integer.parseInt(input.nextLine());
    Department department = createDepartment();
    Employee employee = new Employee(name, salary, department);
    employees.add(employee);
    return employee;
  }

  private static Department createDepartment() {
    System.out.println("Enter employee department:");
    String dept = input.nextLine();
    Department department = null;

    switch (dept.toUpperCase()) {
      case "IT":
      case "HR":
      case "SALES":
        department = new Department(dept, createLocation());
        break;
      default:
        System.out.println("Invalid department!");
        department = createDepartment();
        break;
    }
    return department;
  }

  private static Location createLocation() {
    // Scanner input = new Scanner(System.in);
    System.out.println("Enter employee location:");
    String locName = input.nextLine();
    System.out.println("Enter employee city:");
    String locCity = input.nextLine();
    System.out.println("Enter employee zip code:");
    String locZip = input.nextLine();
    return new Location(locName, locCity, locZip);
  }

  public static void listEmployees() {
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }

  public static void findEmployeeById(String id) {
    Employee employee = null;
    for (Employee emp : employees) {
      if (emp.getEmployeeId().equals(id)) {
        employee = emp;
        break;
      }
    }
    if (employee != null) {
      System.out.println(employee);
    } else {
      System.out.println("Employee not found! \n\n");
    }
  }

  public static void removeAllEmployeesByName(String name) {
    Vector<Employee> removed = new Vector<Employee>();
    for (Employee emp : employees) {
      if (emp.getEmployeeName().equals(name)) {
        removed.add(emp);
      }
    }
    employees.removeAll(removed);
    System.out.println("Removed employees: \n" + removed);
  }

  public static void updateEmployeeById(String id) {
    Employee employee = null;
    for (Employee emp : employees) {
      if (emp.getEmployeeId().equals(id)) {
        employee = emp;
        break;
      }
    }
    int choice = 0;
    do {
      System.out.println("1. Update employee name");
      System.out.println("2. Update employee salary");
      System.out.println("3. Update employee department");
      System.out.println("4. Update employee location");
      System.out.println("0. Exit");
      System.out.println("Enter your choice:");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter employee name:");
          String name = input.next();
          employee.setEmployeeName(name);
          break;
        case 2:
          System.out.println("Enter employee salary:");
          Integer salary = Integer.parseInt(input.nextLine());
          employee.setEmployeeSalary(salary);
          break;
        case 3:
          Department department = createDepartment();
          employee.setDepartment(department);
          break;
        case 4:
          Location location = createLocation();
          employee.getDepartment().setDeptLocation(location);
          break;
        case 0:
          System.out.println("Goodbye!");
          break;
        default:
          System.out.println("Invalid choice!");
          break;
      }
    } while (choice != 0);
  }
}
