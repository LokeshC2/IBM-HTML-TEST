package project2;

public class App {

  public static void main(String[] args) {
    Employee employee = new Employee();

    employee.createEmployee("EMP-1", "John Doe", "10000", new Department());
    employee.department.departmentName = "IT";

    Employee employee2 = new Employee();
    employee2.createEmployee("EMP-2", "Jane Doe", "20000", new Department());
    employee2.department.departmentName = "HR";


    System.out.println(employee.getDetails());
  }
}
