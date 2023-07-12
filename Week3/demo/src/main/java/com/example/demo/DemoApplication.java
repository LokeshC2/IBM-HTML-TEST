package com.example.demo;

import com.example.demo.model.Coach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

  public static void main(String[] args) {
    System.out.println(args.length);
    ApplicationContext context;
    try {
       context= new ClassPathXmlApplicationContext(
        "applicationContext.xml"
      );
      Coach coach = context.getBean("cricketCoach", Coach.class);
      System.out.println(coach.getDailyWorkout());
      System.out.println(coach.getDailyFortune());
      Coach otherCoach = context.getBean("baseballCoach", Coach.class);
      System.out.println(otherCoach.getDailyWorkout());
      System.out.println(otherCoach.getDailyFortune());
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
