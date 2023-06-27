package project3.model;

public class RegularEmployee extends Employee {
  private double salary;

  public RegularEmployee() {
    super();
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  @Override
  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public void getDetails() {
    super.getDetails();
    System.out.println("Salary: " + salary);
  }

  @Override
  public String toString() {
    return super.toString() + "RegularEmployee [salary=" + salary + "]";
  }
}
