package project2;
import java.util.UUID;

public class Employee {

  //attributes
  private String employeeName;
  private String employeeId;
  private Integer employeeSalary;
  private Department department;

  //method
  public Employee(
    String name,
    Integer salary,
    Department dept
  ) {
    if (salary<1000){
      salary = 1000;
    }
    employeeId = UUID.randomUUID().toString();

    employeeName = name;

    employeeSalary = salary;

    department = dept;
  }

  //method
  String getDetails() {
    return (
      "Name: " +
      employeeName +
      " ID: " +
      employeeId +
      " Salary: " +
      employeeSalary +
      " Department: " +
      department.getDetails()
    );
  }
}
