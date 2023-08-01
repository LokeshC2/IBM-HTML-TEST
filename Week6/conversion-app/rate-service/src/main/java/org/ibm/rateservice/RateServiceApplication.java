package org.ibm.rateservice;

import org.ibm.rateservice.service.RateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableDiscoveryClient
@AllArgsConstructor
public class RateServiceApplication implements CommandLineRunner {

	private RateService rateService;

	public static void main(String[] args) {
		SpringApplication.run(RateServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		rateService.save("USD", "INR", 75.0);
		rateService.save("USD", "EUR", 0.9);
	}

}
