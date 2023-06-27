package project3.model;

public class HourlyEmployee extends Employee {
  private double hourlyRate;

  public HourlyEmployee() {
    super();
  }

  public double getHourlyRate() {
    return hourlyRate;
  }

  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }

  @Override
  public void setSalary(int salary) {
    this.hourlyRate = salary / (8 * 20);
  }

  @Override
  public void getDetails() {
    super.getDetails();
    System.out.println("Hourly Rate: " + hourlyRate);
  }

  @Override
  public String toString() {
    return super.toString() + "HourlyEmployee [hourlyRate=" + hourlyRate + "]";
  }
}
