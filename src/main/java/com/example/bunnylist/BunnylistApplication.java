package com.example.bunnylist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class BunnylistApplication {

	public static void main(String[] args) { 

		SpringApplication.run(BunnylistApplication.class, args);
	}
 
}
