package com.example.models;

public class Employee {
  private String name;
  private String position;
  private String salary;

  public Employee(String name, String position, String salary) {
    this.name = name;
    this.position = position;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public String getPosition() {
    return position;
  }

  public String getSalary() {
    return salary;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", position=" + position + ", salary=" + salary + "]";
  }

}
