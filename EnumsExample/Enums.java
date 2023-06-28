package EnumsExample;

public class Enums {

  public static void main(String[] args) {
    Employee e1 = new Employee("1", "A", Dept.IT);
    Employee e2 = new Employee("2", "B", Dept.HR);
    Employee e3 = new Employee("3", "C", Dept.FINANCE);
    Employee e4 = new Employee("4", "D", Dept.MARKETING);

    System.out.println(e1);
    System.out.println(e2);
    System.out.println(e3);
    System.out.println(e4);
  }
}
