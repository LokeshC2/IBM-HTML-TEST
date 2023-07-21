package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customers")
public class Customer {
	@Id
	private int id;
	@Column(name="fname")
	private String firstname;
	@Column(name="lname")
	private String lastname;
	private String email;
}
