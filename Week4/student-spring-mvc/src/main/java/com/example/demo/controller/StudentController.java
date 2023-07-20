package com.example.demo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private DataSource dataSource;
	
	@GetMapping
	public String listStudents(@ModelAttribute List<Student> students, @ModelAttribute List<String> errors) {
		try {
		Connection c = dataSource.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("Select * from student");
		students = new ArrayList<Student>();
		while (rs.next()) {
			students.add(new Student(rs.getString("firstname"), rs.getString("lastname")));
		}
		} catch (SQLException e) {
			errors=new ArrayList<String>();
			errors.add(e.getMessage());
		}
		return "listStudents";
	}
	
	@GetMapping("/showForm") 
	public String showForm(Model model) {
		Student s = new Student();
		model.addAttribute("student", s);
		return "showForm";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(Model model, @ModelAttribute Student student) {
		
		student.getFirstname()
		
		try {
		Connection c = dataSource.getConnection();
		PreparedStatement pst;
			pst = c.prepareStatement("Insert into student (firstname,lastname) values (?,?)");
			pst.setString(1, student.getFirstname());
			pst.setString(2, student.getLastname());
			pst.executeUpdate();
		} catch (SQLException e) {
			List<String> errors = new ArrayList<String>();
			errors.add(e.getMessage());
			model.addAttribute("errors", errors);
			return "showForm";
		}
		return "success";
	}
}
