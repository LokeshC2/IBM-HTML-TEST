package com.example.model;

import lombok.Data;

@Data
public class Employee {
	private static Integer counter = 0;
	private Integer id;
	private String name;
	public Employee (String n) {
		id = counter++;
		name = n;
	}
}
