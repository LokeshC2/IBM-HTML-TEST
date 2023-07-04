package trycatch.employeeProj;

public class Manager extends Employee {
  private Integer bonus;

  public Integer getBonus() {
    return bonus;
  }

  public void setBonus(Integer bonus) {
    this.bonus = bonus;
  }

  @Override
  public Integer getSalary() {
    return super.getSalary() + bonus;
  }

  @Override
  public String toString() {
    return "Manager{" + "bonus=" + bonus + '}';
  }
}