package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.GameManager;
import com.example.model.Game;

public class ListGame extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (PrintWriter out = resp.getWriter()) {
      out.println("<h1>Game List</h1>");
      out.println("<table border='1'>");
      out.println("<tr>");
      out.println("<th>ID</th>");
      out.println("<th>Name</th>");
      out.println("<th>Date</th>");
      out.println("<th>Update</th>");
      out.println("<th>Delete</th>");
      out.println("</tr>");
      List<Game> games = GameManager.getInstance().getGames();
      for (Game game : games) {
        out.println("<tr>");
        out.println("<td>" + game.getId() + "</td>");
        out.println("<td>" + game.getName() + "</td>");
        out.println("<td>" + game.getDate() + "</td>");
        out.println("<td><a href='updateGame?id=" + game.getId() + "'>Update</a></td>");
        out.println("<td><a href='deleteGame?id=" + game.getId() + "'>Delete</a></td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<a href='addGame'>Add Game</a>");
    }
  }
}