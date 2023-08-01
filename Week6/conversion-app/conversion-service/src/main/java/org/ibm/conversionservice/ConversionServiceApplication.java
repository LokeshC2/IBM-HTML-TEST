package org.ibm.conversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@SuppressWarnings("PMD.UseUtilityClass")
public class ConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionServiceApplication.class, args);
	}

}
