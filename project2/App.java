package project2;

public class App {

  public static void main(String[] args) {

    Location pune = new Location("1", "Pune", "Pune", "411001");
    Department hr = new Department("1", "HR", pune);
    Employee john = new Employee("1", "John Doe", 10000, hr);

    Location mumbai = new Location("2", "Mumbai", "Mumbai", "400001");
    Department it = new Department("2", "IT", mumbai);
    Employee jane = new Employee("2", "Jane Doe", 20000, it);

    
    System.out.println(john.getDetails());
    System.out.println(jane.getDetails());
  }
}
