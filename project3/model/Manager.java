package project3.model;

public class Manager extends Employee {
  private String department;

  public Manager() {
    super();
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Override
  public void getDetails() {
    super.getDetails();
    System.out.println("Department: " + department);
  }

  @Override
  public String toString() {
    return super.toString() + "Manager [department=" + department + "]";
  }

}