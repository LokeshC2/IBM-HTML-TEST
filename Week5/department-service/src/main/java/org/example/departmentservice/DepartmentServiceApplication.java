package org.example.departmentservice;

import org.example.departmentservice.model.Department;
import org.example.departmentservice.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor
public class DepartmentServiceApplication implements CommandLineRunner {
	private final DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		departmentRepository.save(new Department("Sales", "Hyderabad"));
		departmentRepository.save(new Department("IT", "Banglore"));
		departmentRepository.save(new Department("Operations", "chennai"));
		
	}

}
