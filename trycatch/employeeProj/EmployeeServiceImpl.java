package trycatch.employeeProj;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
  List<Employee> employees = new ArrayList<Employee>();
  @Override
  public void createEmployee(String name, Integer Salary) {
    System.out.println("Creating employee...");
    Employee e = Employee.createEmployee(name, Salary);
    employees.add(e);
    System.out.println("Employee created: " + e.toString());
  }
  public void listEmployees() {
    System.out.println("Listing employees...");
    for (Employee e : employees) {
      System.out.println(e.toString());
    }
    System.out.println("End of listing");
  }
  public void deleteEmployee(Integer ID) {
    System.out.println("Deleting employee...");
    employees.removeIf(e -> e.getID().equals(ID));
  }
  public void updateEmployee(Integer ID, String name, Integer Salary) {
    System.out.println("Updating employee...");
    for (Employee e : employees) {
      if (e.getID().equals(ID)) {
        if (name != null) e.setName(name);
        if (Salary != null) e.setSalary(Salary);
      }
    }
  }

  public void createContractEmployee(String name, Integer Salary, Integer contractDuration) {
    System.out.println("Creating contract employee...");
    Employee e = Contractor.createContractor(name, Salary, contractDuration);
    employees.add(e);
    System.out.println("Contract employee created: " + e.toString());
  }
}
