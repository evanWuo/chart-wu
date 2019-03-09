package com.wu.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class WuspringclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WuspringclientApplication.class, args);
	}
}
