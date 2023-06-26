package project2;

public class Employee {

  //attributes
  String employeeName;
  String employeeId;
  String employeeSalary;
  Department department;

  //method
  void createEmployee(
    String id,
    String name,
    String salary,
    Department dept
  ) {
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
      "Department: " +
      department.getDetails()
    );
  }
}
