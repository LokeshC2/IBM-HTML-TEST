package com.example.springApp.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope("prototype")
@Setter
@Getter
@ToString
public class Student {

  private int id;
  private String name;

  @PostConstruct
  public void init() {
    System.out.println("Student bean is going through init.");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Student bean will destroy now.");
  }
}
