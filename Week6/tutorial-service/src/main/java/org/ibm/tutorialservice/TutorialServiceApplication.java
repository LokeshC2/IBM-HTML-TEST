package org.ibm.tutorialservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
public class TutorialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialServiceApplication.class, args);
	}

		@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
