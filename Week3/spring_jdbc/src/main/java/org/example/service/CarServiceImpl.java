package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.dao.CarDao;
import org.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carService")
public class CarServiceImpl implements CarService{

  CarDao carDao;
  List<Car> cars = new ArrayList<Car>();

  @Autowired
  public CarServiceImpl(CarDao carDao) throws java.sql.SQLException{
    this.carDao = carDao;
    cars = carDao.listCars();
  }

  @Override
  public void createCar(Car car) throws java.sql.SQLException {
    Car createdCar = carDao.createCar(car);
    cars.add(createdCar);
  }

  @Override
  public java.util.List<Car> listCars() throws java.sql.SQLException {
    if (cars.isEmpty()) {
      cars = carDao.listCars();
    }
    return cars;
  }

  @Override
  public void findCarById(int Id) throws java.sql.SQLException {
    for (Car car : cars) {
      if (car.getId() == Id) {
        System.out.println(car);
        return;
      }
    }
    Car car = carDao.findCarById(Id);
    System.out.println(car);
  }
}
