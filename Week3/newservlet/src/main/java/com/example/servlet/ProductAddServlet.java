package com.example.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductAddServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    try {
      Integer id = Integer.parseInt(request.getParameter("t1"));
      String name = request.getParameter("t2");
      Integer price = Integer.parseInt(request.getParameter("t3"));
      ServletContext context = getServletContext();
      File file = new File(context.getRealPath("/WEB-INF/data.csv"));
      try (FileWriter fWriter = new FileWriter(file, true)) {
        fWriter.write(id + "," + name + "," + price + "\n");
      }
      response.setStatus(200);
      response.sendRedirect("product.list");
    }

    catch (NumberFormatException e) {
      response.setStatus(400);
      response.sendRedirect("index.html");
    }

    catch (IOException e) {
      System.out.println(e.getStackTrace());
      response.setStatus(500);
      response.sendRedirect("index.html");
    }
  }
}