package com.example.bootevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootEventApplication.class, args);
	}

}
