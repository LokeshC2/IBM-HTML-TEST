package com.example.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controller.GameManager;
import com.example.model.Game;

public class UpdateGame extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer id = Integer.parseInt(request.getParameter("id"));
    response.setContentType("text/html");
    try (PrintWriter out = response.getWriter()) {
      out.println("<h1>Update Game #" + id + "</h1>");
      out.println("<form method='post' action='updateGame'>");
      out.println("<input type='hidden' name='id' value='" + id + "' /><br/>");
      out.println("Name: <input type='text' name='name' /><br/>");
      out.println("Date: <input type='text' name='date' /><br/>");
      out.println("<input type='submit' value='Update' />");
      out.println("</form>");
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Integer id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String date = request.getParameter("date");
    GameManager manager = GameManager.getInstance();
    Game game = manager.getGame(id);
    game.setName(name);
    game.setDate(date);
    manager.updateGame(game);
    getServletContext().getRequestDispatcher("/listGames").forward(request, response);
  }
}
