package com.example.service;

import com.example.factory.Connector;
import com.example.models.Course;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {

  @Override
  public void addCourse(String course_name, String instructor_name) {
    try {
      Connector
        .getConnection()
        .createStatement()
        .executeUpdate(
          "INSERT INTO course (course_name, instructor_name) VALUES ('" +
          course_name +
          "', '" +
          instructor_name +
          "')"
        );
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void deleteCourse(int course_id) {
    try {
      Connector
        .getConnection()
        .createStatement()
        .executeUpdate(
          "DELETE FROM course WHERE course_id = " + course_id + ""
        );
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void deleteAllCourses() {
    try {
      Connector
        .getConnection()
        .createStatement()
        .executeUpdate("DELETE FROM course");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public void updateCourse(
    int course_id,
    String course_name,
    String instructor_name
  ) {
    try {
      Connector
        .getConnection()
        .createStatement()
        .executeUpdate(
          "UPDATE course SET course_name = '" +
          course_name +
          "', instructor_name = '" +
          instructor_name +
          "' WHERE course_id = " +
          course_id +
          ""
        );
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  @Override
  public Course getCourse(int course_id) {
    try {
      ResultSet rs = Connector
        .getConnection()
        .createStatement()
        .executeQuery(
          "SELECT * FROM course WHERE course_id = " + course_id + ""
        );
      if (rs.next()) {
        return new Course(rs.getInt(1), rs.getString(2), rs.getString(3));
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public List<Course> getAllCourses() {
    try {
      ResultSet rs = Connector
        .getConnection()
        .createStatement()
        .executeQuery("SELECT * FROM course");
      ArrayList<Course> courses = new ArrayList<Course>();
      while (rs.next()) {
        courses.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3)));
      }
      return courses;
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  @Override
  public List<Course> getCoursesByCourseName(String course_name) {
    try {
      ResultSet rs = Connector
        .getConnection()
        .createStatement()
        .executeQuery(
          "SELECT * FROM course WHERE course_name = '" +
          course_name +
          "'"
        );
      ArrayList<Course> courses = new ArrayList<Course>();
      while (rs.next()) {
        courses.add(new Course(rs.getInt(1), rs.getString(2), rs.getString(3)));
      }
      return courses;
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }
}
