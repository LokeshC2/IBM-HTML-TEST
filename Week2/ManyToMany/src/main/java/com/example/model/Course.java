package com.example.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int courseId;

  private String courseName;
  @ManyToMany(mappedBy = "courses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Collection<Student> students = new ArrayList<Student>();

  public String toString() {
    String result = "Course: " + courseName + " has students: ";
    for (Student student : students) {
      result += student.getStudentName() + ", ";
    }
    return result;
  }

  public void addStudent(Student student) {
    if (students == null) students = new ArrayList<Student>();
    if (!students.contains(student)) return;
    students.add(student);
  }
}
