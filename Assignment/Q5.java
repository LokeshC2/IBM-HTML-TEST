// Q.2 Write a java program which initialization earning of an employee. The program should
// calculate the income tax to be paid by the employee as per the criteria given below:

// Slab rate              IT rate
// Upto Rs. 50,000        Nil
// Upto Rs. 60,000        10% on additional amount
// Upto Rs. 1,50,000      20% on additional amount
// Above Rs. 1,50,000     30% on additional amount
// Hint: - Run: - java calculates 1,25,000
// Result: - income tax is …………………………….

package Assignment;

public class Q5 {

  public static void main(String[] args) {
    Q5 q5 = new Q5();

    IncomeTax[] slabs = {
      q5.new IncomeTax(50000, 0),
      q5.new IncomeTax(60000, 10),
      q5.new IncomeTax(150000, 20),
      q5.new IncomeTax(150000, 30)
    };

    Employee employee = q5.new Employee("1", 125000);
    
    System.out.println(
      "Income tax is: " + q5.calculateTax(employee.getSalary(), slabs)
    );
  }

  public int calculateTax(int salary, IncomeTax[] slabs) {
    int tax = 0;
    for (IncomeTax slab : slabs) {
      tax += slab.calculateTax(salary);
    }
    return tax;
  }

  public class Employee {

    private String id;
    private int salary;

    Employee(String id, int salary) {
      this.id = id;
      this.salary = salary;
    }

    public String getId() {
      return id;
    }

    public int getSalary() {
      return salary;
    }
  }

  public class IncomeTax {

    private int slabBase;
    private int slabRate;

    IncomeTax(int slabBase, int slabRate) {
      this.slabBase = slabBase;
      this.slabRate = slabRate;
    }

    public int calculateTax(int salary) {
      int tax = 0;
      if (salary > slabBase) {
        tax = (salary - slabBase) * slabRate / 100;
      }
      return tax;
    }
  }
}
