package com.fluex404.aurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AurekaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(AurekaserverApplication.class, args);
	}

}
