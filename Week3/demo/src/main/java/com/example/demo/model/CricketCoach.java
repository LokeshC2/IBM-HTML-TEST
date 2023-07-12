package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ToString
public class CricketCoach implements Coach {

  private FortuneService fortuneService;

  public CricketCoach() {
    System.out.println("CricketCoach: inside no-arg constructor");
  }

  @Autowired
  public void setFortuneService(
    @Qualifier("goodFortuneService") FortuneService fortuneService
  ) {
    System.out.println(
      "CricketCoach: inside setter method - setFortuneService"
    );
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Practice fast bowling for 15 minutes";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}
