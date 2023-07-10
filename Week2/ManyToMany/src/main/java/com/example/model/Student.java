package com.example.model;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Object {

  @Column
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;

  @Column
  private String studentName;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Collection<Course> courses;

  public String toString() {
    String result = "Student: " + studentName + " has courses: ";
    for (Course course : courses) {
      result += course.getCourseName() + ", ";
    }
    return result;
  }

  public void addCourse(Course course) {
    if (courses == null) courses = new java.util.HashSet<Course>();
    courses.add(course);
  }
}
