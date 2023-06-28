package Enums;


public class Employee {

  private String id;
  private String name;
  private Dept dept;

  Employee() {}

  Employee(String id, String name, Dept dept) {
    this.id = id;
    this.name = name;
    this.dept = dept;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Dept getDept() {
    return dept;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  @Override
  public String toString() {
    return "Employee [dept=" + dept + ", id=" + id + ", name=" + name + "]";
  }
}