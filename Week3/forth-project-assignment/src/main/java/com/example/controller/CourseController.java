package com.example.controller;

import java.util.List;

import org.hibernate.Session;

import com.example.factory.HibernateFactory;
import com.example.model.Course;

public class CourseController {

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
}
