package com.example;

import com.example.service.CourseService;
import com.example.service.CourseServiceImpl;

public class Tester {
  public static void main(String[] args) {
    CourseService courseService = new CourseServiceImpl();
    courseService.addCourse("Java", "John Doe");
    courseService.addCourse("Python", "Jane Doe");
    courseService.addCourse("C++", "Jack Doe");
    courseService.addCourse("C#", "Jill Doe");
    courseService.getAllCourses();
    courseService.getCourse(1);
    courseService.getCoursesByCourseName("Java");
  }
}
