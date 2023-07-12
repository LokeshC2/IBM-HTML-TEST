package org.example.service;

import java.sql.SQLException;

import org.example.model.Car;

public interface CarService {

  void createCar(Car car) throws SQLException;

  java.util.List<Car> listCars() throws SQLException;

  void findCarById(int Id) throws SQLException;

}