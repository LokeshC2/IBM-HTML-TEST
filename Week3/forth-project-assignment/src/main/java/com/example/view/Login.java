package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.LoginUtility;

public class Login extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try(PrintWriter out = resp.getWriter()) {
      out.write("""
          <html>
          <head>
          <title>Admin Home</title>
          </head>
          <body>
          <h1>Admin Login</h1>
          <form action='login' method='post'>
          <label for='username'>Username</label>
          <input type='text' name='username' id='username' />
          <br />
          <label for='password'>Password</label>
          <input type='password' name='password' id='password' />
          <br />
          <input type='submit' value='Login' />
          </form>
          </body>
          </html>
          """);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    try(PrintWriter out = resp.getWriter()) {
      String res = "";
      try{
        String token = LoginUtility.login(username, password);
        res = """
            <html>
            <head>
            <title>Admin Home</title>
            </head>
            <body>
            <h1>Admin Home</h1>
            <h2>Welcome %s</h2>
            <a href='add?token=%s'>Add Course</a>
            <br />
            <a href='register?token=%s'>Register for Course</a>
            <br />
            <a href='logout?token=%s'>Logout</a>
            </body>
            </html>
            """;
        res = String.format(res, username, token, token, token);
      } catch(Exception e) {
        res = """
            <html>
            <head>
            <title>Admin Home</title>
            </head>
            <body>
            <h1>Admin Home</h1>
            <h2>Invalid Credentials</h2>
            <a href='login'>Login</a>
            </body>
            </html>
            """;
      }
      out.write(res);
    }
  }
}