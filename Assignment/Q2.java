
// Q.2 Create a person inherit two classes from it politician & sportsman provide constructors & 
//      calculate salary & display functions.

package Assignment;

import java.util.Vector;

public class Q2 {
  public static void main(String[] args) {
    Q2 q2 = new Q2();
    int[] winnings = { 1000, 2500, 5000 };
    Sportsman sportsman = q2.new Sportsman("Sportsman", 20, winnings);
    sportsman.display();
    Politician politician = q2.new Politician("Politician", 30, 10000);
    politician.display();
  }

  public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public void salary (){}
    
    public void display() {
      System.out.println("Name: " + this.name);
      System.out.println("Age: " + this.age);
    }

    public String getName() {
      return this.name;
    }

    public int getAge() {
      return this.age;
    }

    public void setName(String name) {
      this.name = name;
    }

    public void setAge(int age) {
      this.age = age;
    }

  }

  public class Politician extends Person {
    private int salary;

    Politician(String name, int age, int salary) {
      super(name, age);
      this.salary = salary;
    }

    @Override
    public void salary() {
      System.out.println("Salary: " + this.salary);
    }

    public void display() {
      super.display();
      this.salary();
    }

    public int getSalary() {
      return this.salary;
    }

    public void setSalary(int salary) {
      this.salary = salary;
    }
  }

  public class Sportsman extends Person {
    private Vector<Integer> winnings;

    Sportsman(String name, int age, Vector<Integer> winnings) {
      super(name, age);
      this.winnings = winnings;
    }

    Sportsman(String name, int age, int[] winnings) {
      super(name, age);
      this.winnings = new Vector<Integer>();
      for (int i = 0; i < winnings.length; i++) {
        this.winnings.add(winnings[i]);
      }
    }

    @Override
    public void salary() {
      int total = 0;
      for (int i = 0; i < this.winnings.size(); i++) {
        total += this.winnings.get(i);
      }
      System.out.println("Salary: " + total);
    }

    public void display() {
      super.display();
      this.salary();
    }

    public Vector<Integer> getWinnings() {
      return this.winnings;
    }

    public void setWinnings(Vector<Integer> winnings) {
      this.winnings = winnings;
    }

    public void addWinnings(int winnings) {
      this.winnings.add(winnings);
    }
  }
}