package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  private String name;
  private String department;
  private Grade grade;
  private String Guide;

  public enum Grade {
    A, B, C, D, E, F
  }
}
