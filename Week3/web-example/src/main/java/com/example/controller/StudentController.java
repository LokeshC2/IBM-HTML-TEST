package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Student;
import com.example.model.Student.Grade;

public class StudentController extends HttpServlet {
  List<Student> students = new ArrayList<Student>();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try (PrintWriter out = resp.getWriter()) {
      resp.setContentType("text/html");

      if (students.isEmpty()) {
        resp.setStatus(HttpServletResponse.SC_OK);
        return;
      }

      out.println("""
          <tr id='table-heading' hx-swap-oob=true>
            <th>Name</th>
            <th>Department</th>
            <th>Grade</th>
            <th>Guide</th>
          </tr>
          """);

      for (Student s : students) {
        out.println("<tr>");
        out.println("<td>" + s.getName() + "</td>");
        out.println("<td>" + s.getDepartment() + "</td>");
        out.println("<td>" + s.getGrade() + "</td>");
        out.println("<td>" + s.getGuide() + "</td>");
        out.println("</tr>");
      }
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name;
    String department;
    Grade grade;

    try {
      name = req.getParameter("name");
      department = req.getParameter("dept");
      grade = Grade.valueOf(req.getParameter("grade"));
    } catch (Exception e) {
      resp.setContentType("text/html");
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      try (PrintWriter out = resp.getWriter()) {
        out.println("<html><head><title>Student</title></head><body>");
        out.println("<h1>Invalid input</h1>");
        out.println("<p>Go back and try again</p>");
        out.println("<a href='./../'>Go back</a>");
        out.println("</body></html>");
      }
      return;
    }

    String guide = getInitParameter("guide");

    Student student = new Student(name, department, grade, guide);
    students.add(student);

    resp.setContentType("text/html");

    try (PrintWriter out = resp.getWriter()) {

      if (students.size() == 1) {
        out.println("""
          <tr id='table-heading' hx-swap-oob=true>
            <th>Name</th>
            <th>Department</th>
            <th>Grade</th>
            <th>Guide</th>
          </tr>
          """);
      }
      out.println("<tr>");
      out.println("<td>" + student.getName() + "</td>");
      out.println("<td>" + student.getDepartment() + "</td>");
      out.println("<td>" + student.getGrade() + "</td>");
      out.println("<td>" + student.getGuide() + "</td>");
      out.println("</tr>");
    }
  }
}
