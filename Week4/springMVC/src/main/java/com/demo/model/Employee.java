package com.demo.model;

import lombok.Data;


@Data
public class Employee {
	private static int count;
	private Integer id;
	private String name;
	private Double salary;
	
	public Employee (String n, Double s) {
		id = count++;
		name = n;
		salary = s;
	}
}
