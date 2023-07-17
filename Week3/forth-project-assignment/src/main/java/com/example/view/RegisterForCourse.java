package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterForCourse extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try (PrintWriter out = response.getWriter()) {
      out.write("""
          <html>
          <head>
          <title>Register for Course</title>
          </head>
          <body>
          <form action='register' method='post'>
          <label for='studentId'>Student Id</label>
          <input type='text' name='studentId' id='studentId' />
          <br />
          <label for='courseId'>Course Id</label>
          <input type='text' name='courseId' id='courseId' />
          <br />
          <input type='submit' value='Register' />
          </form>
          </body>
          </html>
          """);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String studentId = req.getParameter("studentId");
    String courseId = req.getParameter("courseId");
    try (PrintWriter out = resp.getWriter()) {
      String res = """
          <html>
          <head>
          <title>Registered for Course</title>
          </head>
          <body>
          <h1>Student Id: %s is registered for Course Id: %s</h1>
          <a href='index.html'>Home</a>
          </body>
          </html>
          """;
      res = String.format(res, studentId, courseId);
      out.write(res);
    }
  }
}