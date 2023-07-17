package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.GameManager;
import com.example.model.Game;

public class AddGame extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    try (PrintWriter out = response.getWriter()) {
      out.println("<h1>Add Game</h1>");
      out.println("<form method='post' action='addGame'>");
      out.println("Name: <input type='text' name='name' /><br/>");
      out.println("Date: <input type='text' name='date' /><br/>");
      out.println("<input type='submit'/>");
      out.println("</form>");
    }
  }
  
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    String date = request.getParameter("date");
    Game game = new Game();
    game.setName(name);
    game.setDate(date);
    GameManager.getInstance().addGame(game);
    response.sendRedirect("listGames");
  }

}
