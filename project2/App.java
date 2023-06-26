package project2;

public class App {

  public static void main(String[] args) {

    Location pune = new Location("Pune", "Pune", "411001");
    Department hr = new Department("HR", pune);
    Employee john = new Employee("John Doe", 10000, hr);

    Location mumbai = new Location("Mumbai", "Mumbai", "400001");
    Department it = new Department("IT", mumbai);
    Employee jane = new Employee("Jane Doe", 20000, it);

    
    System.out.println(john.getDetails());
    System.out.println(jane.getDetails());
  }
}
