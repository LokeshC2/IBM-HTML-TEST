package trycatch.employeeProj;

public class Contractor extends Employee {
  private Integer hoursWorked;

  public Contractor() {
    super();
  }

  public Contractor(String name, Integer salary, Integer hoursWorked) {
    super();
    this.setName(name);
    this.setSalary(salary);
    this.hoursWorked = hoursWorked;
  }

  public static Contractor createContractor(String name, Integer salary, Integer hoursWorked) {
    Contractor c = new Contractor();
    c.setName(name);
    c.setSalary(salary);
    c.setHoursWorked(hoursWorked);
    return c;
  }

  @Override
  public Integer getSalary() {
    if (hoursWorked == null) {
      throw new HoursNotSetException("Hours not set");
    }
    return super.getSalary() * hoursWorked;
  }

  public Integer getHoursWorked() {
    return hoursWorked;
  }

  public void setHoursWorked(Integer hoursWorked) {
    this.hoursWorked = hoursWorked;
  }

  @Override
  public String toString() {
    return "Contractor{" + "hoursWorked=" + hoursWorked + '}';
  }
}