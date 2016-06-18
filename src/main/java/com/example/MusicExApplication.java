package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@EnableAutoConfiguration
@SpringBootApplication
public class MusicExApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicExApplication.class, args);
	}
}
