package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.LoginUtility;

public class Login extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String token = null;

    for (Cookie cookie : req.getCookies()) {
      if ("token".equals(cookie.getName())) {
        token = cookie.getValue();
      }
    }

    if (LoginUtility.validateToken(token)) {
      showLoggedInPage(resp, "admin");
      return;
    }
    try (PrintWriter out = resp.getWriter()) {
      out.write(
          "<html>" +
              "<head>" +
              "<title>Admin Home</title>" +
              "</head>" +
              "<body>" +
              "<h1>Admin Login</h1>" +
              "<form action='login' method='post'>" +
              "<label for='username'>Username</label>" +
              "<input type='text' name='username' id='username' />" +
              "<br />" +
              "<label for='password'>Password</label>" +
              "<input type='password' name='password' id='password' />" +
              "<br />" +
              "<input type='submit' value='Login' />" +
              "</form>" +
              "</body>" +
              "</html>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String token = LoginUtility.login(username, password);
    if (token != null) {
      Cookie cookie = new Cookie("token", token);
      cookie.setMaxAge(300);
      resp.addCookie(cookie);
      showLoggedInPage(resp, username);
    } else {
      resp.sendError(401, "Invalid Credentials");
    }
  }

  private void showLoggedInPage(HttpServletResponse resp, String username)
      throws IOException {
    try (PrintWriter out = resp.getWriter()) {
      String res = "<html>" +
          "<head>" +
          "<title>Admin Home</title>" +
          "</head>" +
          "<body>" +
          "<h1>Admin Home</h1>" +
          "<h2>Welcome %s</h2>" +
          "<a href='course.add'>Add Course</a>" +
          "<br />" +
          "<a href='course.register'>Register for Course</a>" +
          "<br />" +
          "<a href='admin/logout'>Logout</a>" +
          "</body>" +
          "</html>";
      res = String.format(res, username);
      out.write(res);
    }
  }
}