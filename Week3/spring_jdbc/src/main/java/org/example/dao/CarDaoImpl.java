package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.factory.CarFactory;
import org.example.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carDao")
public class CarDaoImpl implements CarDao {

  private CarFactory carFactory;

  @Autowired
  public CarDaoImpl(CarFactory carFactory) {
    this.carFactory = carFactory;
  }

  @Override
  public Car createCar(Car car) throws SQLException {
    Connection connection = carFactory.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO car (model, color) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
    preparedStatement.setString(1, car.getModel());
    preparedStatement.setString(2, car.getColor());
    Car createdCar = new Car();
    preparedStatement.executeUpdate();
    ResultSet resultSet = preparedStatement.getGeneratedKeys();
    if (resultSet.next()) {
      createdCar.setId(resultSet.getInt(1));
    }
    createdCar.setModel(car.getModel());
    createdCar.setColor(car.getColor());
    return createdCar;
  }

  @Override
  public List<Car> listCars() throws SQLException {
    Connection connection = carFactory.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car");
    ResultSet resultSet = preparedStatement.executeQuery();
    List<Car> cars = new ArrayList<>();
    while (resultSet.next()) {
      Car car = new Car();
      car.setId(resultSet.getInt("id"));
      car.setModel(resultSet.getString("model"));
      car.setColor(resultSet.getString("color"));
      cars.add(car);
    }
    return cars;
  }

  @Override
  public Car findCarById(int Id) throws SQLException {
    Connection connection = carFactory.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE id = ?");
    preparedStatement.setInt(1, Id);
    ResultSet resultSet = preparedStatement.executeQuery();
    Car car = new Car();
    if (resultSet.next()) {
      car.setId(resultSet.getInt("id"));
      car.setModel(resultSet.getString("model"));
      car.setColor(resultSet.getString("color"));
    }
    return car;
  }
}
