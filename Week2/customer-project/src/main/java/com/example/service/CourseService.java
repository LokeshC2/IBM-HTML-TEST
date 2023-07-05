package com.example.service;

import java.util.List;

import com.example.models.Course;

public interface CourseService {
  public void addCourse(String course_name, String instructor_name);
  public void updateCourse(int course_id, String course_name, String instructor_name);
  public void deleteCourse(int course_id);
  public Course getCourse(int course_id);
  public List<Course> getAllCourses();
  public List<Course> getCoursesByCourseName(String course_name);
  public void deleteAllCourses();
}
