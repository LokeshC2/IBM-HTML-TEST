package project2;
import java.util.UUID;

public class Employee {

  //attributes
  private String employeeName;
  private String employeeId;
  private Integer employeeSalary;
  private Department department;

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }


  public Integer getEmployeeSalary() {
    return employeeSalary;
  }

  public void setEmployeeSalary(Integer employeeSalary) {
    this.employeeSalary = employeeSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  //method
  public Employee(
    String name,
    Integer salary,
    Department dept
  ) {
    if (salary<1000){
      salary = 1000;
    }
    employeeId = UUID.randomUUID().toString().substring(0, 8);

    employeeName = name;

    employeeSalary = salary;

    department = dept;
  }

  @Override
  public String toString() {
    return (
      "Employee ID: " + employeeId + "\n" +
      "Employee Name: " + employeeName + "\n" +
      "Employee Salary: " + employeeSalary + "\n" +
      "Employee Department: \n" + department
    );
  }

  public void getDetails() {
  }
}
