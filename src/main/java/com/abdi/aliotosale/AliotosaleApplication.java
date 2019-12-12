package com.abdi.aliotosale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AliotosaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AliotosaleApplication.class, args);
	}

}
