package org.fkit.springboot.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class);
//		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}
}
