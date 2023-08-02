package org.ibm.tutorialservice.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@EnableWebSecurity
public class Securityconfig {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {

		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(configurer -> configurer
			.antMatchers(HttpMethod.GET, "/tutorials").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.GET, "/tutorials/**").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.POST, "/tutorials").hasRole("MANAGER")
			.antMatchers(HttpMethod.PUT, "/tutorials").hasRole("MANAGER")
			.antMatchers(HttpMethod.DELETE, "/tutorials/**").hasRole("ADMIN"));
		http.httpBasic();
		http.cors().disable();
		http.csrf().disable();
		return http.build();
	}
}