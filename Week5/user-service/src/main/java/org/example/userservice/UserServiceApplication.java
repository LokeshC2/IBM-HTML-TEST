package org.example.userservice;

import org.example.userservice.dto.UserDto;
import org.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// @EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserDto user = new UserDto();
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setEmail("jd@example.com");
		user.setPassword("123456");
		user.setUserId("jd123");
		userService.createUser(user);

		user = new UserDto();
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setEmail("jjd@example.com");
		user.setPassword("asdfgh");
		user.setUserId("jjd123");
		userService.createUser(user);
	}

}
