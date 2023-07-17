package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.AppController;
import com.example.controller.LoginUtility;
import com.example.model.Course;

public class CourseList extends HttpServlet {

  AppController courseController = new AppController();

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String token = req.getParameter("token");
    if (LoginUtility.validateToken(token)) {
      super.service(req, resp);
    } else {
      resp.sendError(401, "Invalid Token");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      List<Course> courses = courseController.getCourses();
      response.setContentType("text/html");
      try (PrintWriter out = response.getWriter()) {

        out.println("<table>");
        out.println("<tr>");
        out.println("<th>Id</th>");
        out.println("<th>Name</th>");
        out.println("<th>Price</th>");
        out.println("</tr>");

        for (Course course : courses) {
          out.println("<tr>");
          out.println("<td>" + course.getId() + "</td>");
          out.println("<td>" + course.getName() + "</td>");
          out.println("<td>" + course.getPrice() + "</td>");
          out.println("</tr>");
        }

        out.println("</table>");
        out.println("<a href='index.html'>Home</a>");
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }
}
