package org.ibm.studentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@SuppressWarnings("PMD.UseUtilityClass")
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
}