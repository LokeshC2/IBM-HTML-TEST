package com.example.controller;

import java.util.List;

import org.hibernate.Session;

import com.example.factory.HibernateFactory;
import com.example.model.Course;
import com.example.model.Student;

public class AppController {

  public Course addCourse(String courseName, Double coursePrice) {
    Session session = HibernateFactory.getInstance().getSession();
    session.beginTransaction();
    Course course = new Course(courseName, coursePrice);
    session.save(course);
    course.getId();
    session.getTransaction().commit();
    session.close();
    return course;
  }

  public List<Course> getCourses() {
    Session session = HibernateFactory.getInstance().getSession();
    session.beginTransaction();
    List<Course> courses = session.createQuery("from Course", Course.class).list();
    session.getTransaction().commit();
    session.close();
    return courses;
  }

  public String registerStudent(String courseId, String studentName) {
    Session session = HibernateFactory.getInstance().getSession();
    session.beginTransaction();
    Course course = session.get(Course.class, courseId);
    if (course == null) {
      session.getTransaction().commit();
      session.close();
      return null;
    }
    Student student = new Student();
    student.setName(studentName);
    course.addStudent(student);
    session.save(course);
    session.getTransaction().commit();
    session.close();
    return student.getId().toString();
  }
}
