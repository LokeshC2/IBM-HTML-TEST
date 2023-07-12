package com.example.service;

import com.example.dao.CarDao;
import com.example.entity.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carService")
public class CarServiceImpl implements CarService {

  private CarDao carDao;

  @Autowired
  public CarServiceImpl(CarDao carDao) {
    this.carDao = carDao;
  }

  @Override
  public int createCar(String model, String color) {
    Car car = carDao.createCar(model, color);
    carDao.saveCar(car);
    System.out.println("Car created with id: " + car.getId());
    return car.getId();
  }

  @Override
  public void listCars() {
    System.out.println("Listing cars:");
    carDao.listCars().forEach(System.out::println);
    System.out.println("End of list");
  }

  @Override
  public void findCarById(int id) {
    Car car = carDao.getCarById(id);
    System.out.println(car);
  }

  @Override
  public void updateCar(int id, String model, String color) {
    Car car = carDao.getCarById(id);
    car.setModel(model);
    car.setColor(color);
    carDao.updateCar(car);
    System.out.println("Car updated with id: " + car.getId());
    System.out.println("New car details: " + car);
  }

  @Override
  public void deleteCar(int id) {
    Car car = carDao.getCarById(id);
    if (car == null) {
      System.out.println("Car not found with id: " + id);
      return;
    }
    carDao.deleteCar(car);
    System.out.println("Car deleted with id: " + car.getId());
  }
}
