package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.example.model.Game;

public final class GameManager {

  private static final GameManager instance = new GameManager();
  private static Map<Integer, Game> games = new HashMap<Integer, Game>();
  private static int nextId = 1;

  public Game getGame(Integer id) {
    return games.get(id);
  }

  public List<Game> getGames() {
    return new ArrayList<Game>(games.values());
  }

  public void addGame(Game game) {
    game.setId(nextId);
    games.put(nextId++, game);
  }

  public void updateGame(Game game) {
    games.put(game.getId(), game);
  }

  public static GameManager getInstance() {
    return instance;
  }

  public void deleteGame(Integer id) {
    games.remove(id);
  }
}
