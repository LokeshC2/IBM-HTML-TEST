package org.ibm.tutorialservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
public class TutorialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialServiceApplication.class, args);
	}

}
