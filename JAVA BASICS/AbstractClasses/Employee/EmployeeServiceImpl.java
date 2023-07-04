package AbstractClasses.Employee;

import java.util.Scanner;
import java.util.Vector;

// public class EmployeeServiceImpl extends EmployeeService {
public class EmployeeServiceImpl implements EmployeeService {

  private Vector<Employee> employees = new Vector<Employee>();
  private static int count = 0;

  @Override
  public Employee createEmployee(
    String firstName,
    String lastname,
    String email,
    int salary
  ) {
    String id = ++count + "";
    Employee e = new Employee(id, firstName, lastname, email, salary);
    employees.add(e);
    return e;
  }

  public void displayAllEmployees() {
    if (employees.size() == 0) {
      System.out.println("No employees to display");
      return;
    }
    
    for (Employee e : employees) {
      System.out.println(e);
    }
  }

  public Boolean deleteEmployeeById(String id) {
    int index = -1;
    for (int i = 0; i < employees.size(); i++) {
      if (employees.get(i).getId().equals(id)) {
        index = i;
        break;
      }
    }
    if (index > -1) {
      employees.removeElementAt(index);
      return true;
    }
    return false;
  }

  public Boolean updateEmployeeByid(String id) {
    int index = -1;
    for (int i = 0; i < employees.size(); i++) {
      String eid = employees.get(i).getId();
      if (eid.equals(id)) {
        index = i;
        break;
      }
    }
    if (index > -1) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter new first name (or press enter to skip): ");
      String firstName = sc.nextLine();
      System.out.println("Enter new last name (or press enter to skip): ");
      String lastName = sc.nextLine();
      System.out.println("Enter new email (or press enter to skip): ");
      String email = sc.nextLine();
      System.out.println("Enter new salary (or press enter to skip): ");
      String salary = sc.nextLine();  
    
      if (firstName != "") {
        employees.elementAt(index).setFirstName(firstName);
      }
      if (lastName != "") {
        employees.elementAt(index).setLastName(lastName);
      }
      if (email != "") {
        employees.elementAt(index).setEmail(email);
      }
      if (salary != "") {
        employees.elementAt(index).setSalary(Integer.parseInt(salary));
      }
      sc.close();
      return true;
    }
    return false;
  }
}
