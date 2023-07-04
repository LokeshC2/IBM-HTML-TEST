package trycatch.employeeProj;

public class Employee {
  private static Integer nextID = 0;
  private Integer ID = 0;
  private String name;
  private Integer Salary;

  public Integer getID() {
    return ID;
  }

  protected Employee(){
    this.ID = nextID++;
  }

  public static Employee createEmployee(String name, Integer Salary) {
    Employee e = new Employee();
    e.setName(name);
    e.setSalary(Salary);
    return e;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name.length() < 3) {
      throw new NameTooShortException("Name must be at least 3 characters");
    }
    this.name = name;
  }

  public Integer getSalary() {
    return Salary;
  }

  public void setSalary(Integer Salary) {
    if (Salary < 0) {
      throw new IllegalArgumentException("Salary must be positive");
    }
    this.Salary = Salary;
  }

  @Override
  public String toString() {
    return "Employee{" + "ID=" + ID + ", name=" + name + ", Salary=" + Salary + '}';
  }
}