package com.example.demo.model;

public class BadFortuneService implements FortuneService {
  @Override
  public String getFortune() {
    return "Today is your unlucky day!";
  }
}