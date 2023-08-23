package com.flow.extblocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExtBlockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtBlockerApplication.class, args);
	}

}
