package com.isa_mrs_tim7.isa_mrs_tim7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IsaMrsTim7Application {

	public static void main(String[] args) {
		SpringApplication.run(IsaMrsTim7Application.class, args);
	}
}
