package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import org.example.config.SpringConfig;
import org.example.model.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(SpringConfig.class);

      DataSource dataSource = context.getBean("dataSource", DataSource.class);

      Car car = context.getBean("car", Car.class);
      System.out.println(car);

      Car car2 = context.getBean("car", Car.class);

      car.setColor("Red");
      car2.setColor("Blue");

      car.saveTo(dataSource);
      car2.saveTo(dataSource);

      PreparedStatement preparedStatement = dataSource
        .getConnection()
        .prepareStatement("SELECT * FROM car");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        System.out.println(
          resultSet.getInt("id") +
          " " +
          resultSet.getString("model") +
          " " +
          resultSet.getString("color")
        );
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
