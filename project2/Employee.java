package project2;

public class Employee {

  //attributes
  private String employeeName;
  private String employeeId;
  private Integer employeeSalary;
  private Department department;

  //method
  void createEmployee(
    String id,
    String name,
    Integer salary,
    Department dept
  ) {
    if (salary<1000){
      salary = 1000;
    }
    employeeId = id;

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
