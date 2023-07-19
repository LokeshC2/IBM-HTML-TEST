package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Employee;

@Controller
public class MyController {

	@Autowired
	private DataSource dataSource;

	@GetMapping
	public String home() {
		return "index";
	}

	@GetMapping("/showForm")
	public String showForm() {
		return "showForm";
	}

	@PostMapping("/addEmployee")
	public String processForm(@RequestParam(name = "name") String n, @RequestParam(name = "salary") Double s,
			Model model) {
		Employee e = new Employee(n, s);
		model.addAttribute("emp", e);
		Connection c;
		try {
			c = dataSource.getConnection();
			PreparedStatement pst = c.prepareStatement("Insert into employees (id, name, salary) values (?, ?, ?);");
			pst.setInt(1, e.getId());
			pst.setString(2, e.getName());
			pst.setDouble(3, e.getSalary());
			pst.executeUpdate();
		} catch (SQLException e1) {
			model.addAttribute("err", e1);
		}
		return "success";
	}
}
