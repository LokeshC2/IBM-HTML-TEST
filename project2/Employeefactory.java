package project2;

import java.util.Scanner;

public class Employeefactory {
  static Scanner input = new Scanner(System.in);
  
  public static Employee createEmployee() {
    System.out.println("Enter employee name:");
    String name = input.nextLine();
    System.out.println("Enter employee salary:");
    Integer salary = Integer.parseInt(input.nextLine());
    Department department = createDepartment();
    return new Employee(name, salary, department);
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
}
