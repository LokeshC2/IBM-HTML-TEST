package com.example;

import com.example.factory.MySessionFactory;
import com.example.model.*;

import java.util.List;

import org.hibernate.Session;

public class Tester {

  public static void main(String[] args) {
    Student s1 = new Student();
    s1.setStudentName("John");
    Student s2 = new Student();
    s2.setStudentName("Mary");
    Student s3 = new Student();
    s3.setStudentName("Jane");
    Course c1 = new Course();
    c1.setCourseName("Java");
    Course c2 = new Course();
    c2.setCourseName("Python");

    s1.addCourse(c1);
    s1.addCourse(c2);
    s2.addCourse(c1);
    s3.addCourse(c2);

    Session session = MySessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(s1);
    session.save(s2);
    session.save(s3);
    session.getTransaction().commit();
    session.close();

    session = MySessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    List<Student> students = session.createQuery("from Student", Student.class).list();
    List<Course> courses = session.createQuery("from Course", Course.class).list();
    courses.forEach(System.out::println);
    students.forEach(System.out::println);
    session.getTransaction().commit();
    session.close();

  }
}
