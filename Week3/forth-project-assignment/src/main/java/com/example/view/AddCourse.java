package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.CourseController;
import com.example.controller.LoginUtility;

public class AddCourse extends HttpServlet {

  CourseController courseController = new CourseController();

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
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (PrintWriter out = resp.getWriter()) {
      out.write("""
          <html>
          <head>
          <title>Add Course</title>
          </head>
          <body>
          <form action='add' method='post'>
          <label for='courseName'>Course Name</label>
          <input type='text' name='courseName' id='courseName' />
          <br />
          <label for='coursePrice'>Course Price</label>
          <input type='text' name='coursePrice' id='coursePrice' />
          <br />
          <input type='submit' value='Add' />
          </form>
          </body>
          </html>
          """);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String courseName = req.getParameter("courseName");
    String coursePriceString = req.getParameter("coursePrice");
    Double coursePrice = null;
    try {
      coursePrice = Double.parseDouble(coursePriceString);
    } catch (NumberFormatException e) {
      resp.sendError(400, "Invalid Price");
      return;
    }

    try{
      courseController.addCourse(courseName, coursePrice);
    } catch (Exception e) {
      resp.sendError(500, "Internal Server Error");
      return;
    }

    try (PrintWriter out = resp.getWriter()) {
      String res = """
          <html>
          <head>
          <title>Added Course</title>
          </head>
          <body>
          <h1>Course Name: %s is added with Price: %s</h1>
          <a href='index.html'>Home</a>
          </body>
          </html>
          """;
      res = String.format(res, courseName, coursePrice);
      out.write(res);
    }
  }
}
