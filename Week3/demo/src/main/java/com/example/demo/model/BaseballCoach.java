package com.example.demo.model;

public class BaseballCoach implements Coach {
  private FortuneService fortuneService;

  public BaseballCoach(FortuneService fortuneService) {
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