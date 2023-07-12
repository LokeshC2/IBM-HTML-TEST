package org.example;

import org.example.config.SpringConfig;
import org.example.model.Car;
import org.example.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(SpringConfig.class);

      CarService carService = context.getBean("carService", CarService.class);

      Car car = context.getBean("car", Car.class);

      car.setModel("BMW");
      car.setColor("Black");
      carService.createCar(car);

      car.setModel("Audi");
      car.setColor("White");
      carService.createCar(car);

      car.setModel("Mercedes");
      car.setColor("Silver");
      carService.createCar(car);
      
      carService.listCars().forEach(System.out::println);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
