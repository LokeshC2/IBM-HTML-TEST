package com.example.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.League;
import com.mysql.cj.PreparedQuery;

@Controller
public class LeagueController {

	@Autowired
	private DataSource datasource;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/listLeague")
	public String listLeague(Model model) throws SQLException {
		Connection c = datasource.getConnection();
		Statement s = c.createStatement();
		ResultSet r = s.executeQuery("Select * from League");
		List<League> l = new ArrayList<League>();
		while (r.next()) {
			l.add(new League(r.getInt("id"), r.getString("season"), r.getString("title"), r.getInt("year")));
		}
		model.addAttribute("leagues", l);
		return "listLeague";
	}

	@GetMapping("/addLeague")
	public String getAddLeague(Model model) {
		List<String> errors = new ArrayList<String>();
		model.addAttribute("ERROR", errors);

		List<String> seasons = List.of("Summer", "Winter", "Autumn", "Spring");
		model.addAttribute("seasons", seasons);
		return "addLeague";
	}

	@PostMapping("/addLeague")
	public String postAddLeague(@RequestParam("title") String title, @RequestParam("season") String season,
			@RequestParam("year") String yearString, Model model) {
		List<String> errors = new ArrayList<String>();

		if (title == null || title.isBlank())
			errors.add("Title must be valid");

		List<String> seasons = List.of("Summer", "Winter", "Autumn", "Spring");
		model.addAttribute("seasons", seasons);
		if (season == null || !seasons.contains(season))
			errors.add("Season  invalid!");

		Integer year;
		try {
			year = Integer.parseInt(yearString);
		} catch (Exception e) {
			year = null;
			errors.add("Year must be a number (" + e.getMessage() + ")");
		}

		if (errors.isEmpty()) {
			try {
				Connection c = datasource.getConnection();
				PreparedStatement ps = c.prepareStatement("Insert into League (title, season, year) values (?,?,?)");
				ps.setString(1, title);
				ps.setString(2, season);
				ps.setInt(3, year);
				ps.execute();
			} catch (SQLException e) {
				errors.add("Database entry failed" + e.getMessage());
			}
		}

		model.addAttribute("ERROR", errors);
		if (errors.isEmpty()) {
			return "success";
		} else {
			return "addLeague";
		}
	}
}