package com.example.springApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.springApp.model.Department;
import com.example.springApp.model.Employee;
import com.example.springApp.model.Location;

@Configuration
@ComponentScan(basePackages = "com.example.springApp.model")
@PropertySource("classpath:application.properties")
public class SpringConfig {
  
  @Bean
  public Employee employee() {
    return new Employee();
  }

  @Bean
  public Department department() {
    return new Department();
  }

  @Bean
  public Location location() {
    return new Location();
  }
}
