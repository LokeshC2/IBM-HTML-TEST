package com.example.springApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {

  private char Symbol;
  @Value("${department.name}")
  private String name;

  @Autowired
  private Location location;
}
