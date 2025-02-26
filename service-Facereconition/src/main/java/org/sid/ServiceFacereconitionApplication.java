package org.sid;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceFacereconitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFacereconitionApplication.class, args);
	}

}
