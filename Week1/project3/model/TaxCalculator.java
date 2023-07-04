package project3.model;

public class TaxCalculator {
  
  public void calculateTax(Employee e) {
    if (e instanceof RegularEmployee) {
      System.out.println("Tax: " + ((RegularEmployee) e).getSalary() * 0.05);
    } else if (e instanceof HourlyEmployee) {
      System.out.println("Tax: NIL");
    } else if (e instanceof Manager) {
      System.out.println("Tax: NIL");
    } else if (e instanceof Employee) {
      System.out.println("Tax: NIL");
    }
  }
}
