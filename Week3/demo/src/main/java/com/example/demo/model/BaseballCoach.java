package com.example.demo.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
  
  private FortuneService fortuneService;
  
  public BaseballCoach(@Qualifier("badFortuneService") FortuneService fortuneService) {
    System.out.println("Inside Baseball Coach Constructor");
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Spend 30 minutes on batting practice";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}