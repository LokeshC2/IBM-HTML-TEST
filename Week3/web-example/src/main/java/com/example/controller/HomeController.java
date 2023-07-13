package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name;
    Integer age;
    String output = """
        <html>
        <head>
        <title>Home</title>
        </head>
        <body>
        <h1>Hello, %s </h1>
        <h2>You are %d years old</h2>
        </body>
        </html>
        """;
    try {
      name = req.getParameter("name");
      age = Integer.parseInt(req.getParameter("age"));

      if (name == null || name.isBlank()) {
        name = "World";
      }

      output = String.format(output, name, age);
      resp.getWriter().println(output);
    } catch (NumberFormatException e) {
      resp.getWriter().println("Invalid age");
    }
  }
}
