package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Car;

public interface CarDao {

  Car createCar(Car car) throws SQLException;

  List<Car> listCars() throws SQLException;

  Car findCarById(int Id) throws SQLException;

}
