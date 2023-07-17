package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.AppController;

public class StudentCourseRegistration extends HttpServlet {

  AppController controller = new AppController();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try (PrintWriter out = response.getWriter()) {
      out.write(
          "<html>" +
              "<head>" +
              "<title>Register for Course</title>" +
              "</head>" +
              "<body>" +
              "<form action='register' method='post'>" +
              "<label for='studentName'>Student Name</label>" +
              "<input type='text' name='studentName' id='studentName' />" +
              "<br />" +
              "<label for='courseId'>Course Id</label>" +
              "<input type='text' name='courseId' id='courseId' />" +
              "<br />" +
              "<input type='submit' value='Register' />" +
              "</form>" +
              "</body>" +
              "</html>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String courseId = req.getParameter("courseId");
    String studentName = req.getParameter("studentName");
    String registrationId;
    try {
      registrationId = controller.registerStudent(courseId, studentName);
    } catch (Exception e) {
      resp.sendError(400, "Invalid Course Id");
      return;
    }
    try (PrintWriter out = resp.getWriter()) {
      String res = "<html>" +
          "<head>" +
          "<title>Registered for Course</title>" +
          "</head>" +
          "<body>" +
          "<h1>Registered for Course</h1>" +
          "<h2>Course Id: %s</h2>" +
          "<br />" +
          "<h2>Registration Id: %s</h2>" +
          "<a href='index.html'>Home</a>" +
          "</body>" +
          "</html>";
      res = String.format(res, courseId, registrationId);
      out.write(res);
    }
  }
}