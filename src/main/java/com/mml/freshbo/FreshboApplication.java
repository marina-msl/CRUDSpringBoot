package com.mml.freshbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class FreshboApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshboApplication.class, args);
	}
}

