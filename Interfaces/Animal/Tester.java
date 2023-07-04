package Interfaces.Animal;

public class Tester {
  public static void main(String[] args) {
    Animal dog = new Dog();
    dog.speak();
    System.out.println(dog.toString());
  }
}
