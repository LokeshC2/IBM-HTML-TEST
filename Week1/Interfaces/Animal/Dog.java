package Interfaces.Animal;

public class Dog implements Animal {

  @Override
  public void speak() {
    System.out.println("Dog is barking");
  }

  @Override
  public String toString() {
    return "Dog";
  }
}
