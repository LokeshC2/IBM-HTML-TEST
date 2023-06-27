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
}
