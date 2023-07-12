package org.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {

  private int id;

  @Value("${car.model}")
  private String model;

  private String color;

  public void saveTo(DataSource dataSource) {
    try {
      PreparedStatement preparedStatement = dataSource
        .getConnection()
        .prepareStatement(
          "INSERT INTO car (model, color) VALUES (?, ?)",
          PreparedStatement.RETURN_GENERATED_KEYS
        );
      preparedStatement.setString(1, model);
      preparedStatement.setString(2, color);

      this.id = preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
