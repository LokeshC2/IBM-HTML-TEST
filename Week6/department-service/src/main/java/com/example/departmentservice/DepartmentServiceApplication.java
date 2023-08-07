package com.example.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
// @EnableSwagger2
@SuppressWarnings("PMD.UseUtilityClass")
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
