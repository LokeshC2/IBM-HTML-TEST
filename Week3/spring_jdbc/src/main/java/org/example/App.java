package org.example;

import org.example.config.SpringConfig;
import org.example.dao.CarDao;
import org.example.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(SpringConfig.class);

      CarDao carDao = context.getBean("carDao", CarDao.class);

      Car car = context.getBean("car", Car.class);

      car.setModel("BMW");
      car.setColor("Black");
      carDao.createCar(car);

      car.setModel("Audi");
      car.setColor("White");
      carDao.createCar(car);

      car.setModel("Mercedes");
      car.setColor("Silver");
      carDao.createCar(car);
      
      carDao.listCars().forEach(System.out::println);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
