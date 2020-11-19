package com.adaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class MicroserviceTacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTacheApplication.class, args);
	}

}
