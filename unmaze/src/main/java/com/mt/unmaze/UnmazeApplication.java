package com.mt.unmaze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UnmazeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnmazeApplication.class, args);
	}

}
