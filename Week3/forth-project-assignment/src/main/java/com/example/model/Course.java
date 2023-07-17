package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.ToString
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @Column(name = "course_name")
  private String name;
  @Column(name = "course_price")
  private double price;
  @ManyToMany(mappedBy = "courses", cascade = javax.persistence.CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Student> students;

  public Course(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public void addStudent(Student student) {
    students.add(student);
  }
}