package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name;
    Integer age;
    try {
      name = req.getParameter("name");
      age = Integer.parseInt(req.getParameter("age"));
    } catch (NumberFormatException e) {
      resp.getWriter().println("Invalid age");
      return;
    }
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
    if (name == null || name.isBlank()) {
      name = "World";
    }
    output = String.format(output, name, age);
    resp.setContentType("text/html");
    resp.getWriter().println(output);
  }
}
