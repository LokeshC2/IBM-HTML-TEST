package org.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.example.model")
@PropertySource("classpath:application.properties")
public class SpringConfig {

  @Bean
  DataSource dataSource() {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/springDb");
    dataSource.setUser("lox");
    dataSource.setPassword("mysql0");
    dataSource.setMinPoolSize(5);
    dataSource.setMaxPoolSize(20);
    dataSource.setMaxIdleTime(5000);
    
    return dataSource;
  }
}
