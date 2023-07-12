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
    car.setId(preparedStatement.executeUpdate());
    return car;
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
  
}
