package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class LoginUtility {

  private LoginUtility() {
  }

  private static List<String> tokens = new ArrayList<String>();

  private static String newToken() {
    return UUID.randomUUID().toString();
  }

  public static boolean validateToken(String token) {
    return tokens.contains(token);  
  }

  public static String login(String username, String password) {
    if ("admin".equals(username)) {
      if ("admin".equals(password)) {
        String token = newToken();
        tokens.add(token);
        return token;
      }
      throw new RuntimeException("Invalid Password");
    }
    throw new RuntimeException("Invalid Username");
  }

  public static void logout(String token) {
    tokens.remove(token);
  }
}