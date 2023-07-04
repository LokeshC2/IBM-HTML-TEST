package Interfaces.Flyable;

public class Tester {
  public static void main(String[] args) {
    Flyable[] flyingObjects = new Flyable[3];
    flyingObjects[0] = new Helicopter();
    flyingObjects[1] = new Airplane();
    flyingObjects[2] = new Spacecraft();
    for (Flyable flyingObject : flyingObjects) {
      flyingObject.fly_obj();
    }
  }
}