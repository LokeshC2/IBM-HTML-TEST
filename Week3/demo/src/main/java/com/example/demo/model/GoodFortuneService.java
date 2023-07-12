package com.example.demo.model;
import org.springframework.stereotype.Component;

@Component
public class GoodFortuneService implements FortuneService {
  @Override
  public String getFortune() {
    return "Today is your lucky day!";
  }
}