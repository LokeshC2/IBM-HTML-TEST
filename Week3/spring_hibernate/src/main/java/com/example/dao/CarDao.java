package com.example.dao;

import java.util.List;

import com.example.entity.Car;

public interface CarDao {

  Car createCar(String model, String color);

  void saveCar(Car car);

  List<Car> listCars();

  Car getCarById(int id);

  void updateCar(Car car);

  void deleteCar(Car car);

}