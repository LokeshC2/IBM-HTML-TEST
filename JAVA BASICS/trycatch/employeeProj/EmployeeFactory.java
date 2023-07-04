package trycatch.employeeProj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {
  private BufferedReader reader = null;
  private List<Employee> employees = null;
  
  public EmployeeFactory(){
    reader = new BufferedReader(new InputStreamReader(System.in));
    employees = new ArrayList<Employee>();
  }

  public void createEmployee() throws IOException {
      System.out.println("Enter name: ");
      String name = reader.readLine();
      System.out.println("Enter Salary: ");
      Integer Salary = Integer.parseInt(reader.readLine());
      Employee e = Employee.createEmployee(name, Salary);
      employees.add(e);
  }
}