package com.claro.itec.xpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.claro.itec.xpapi"})
public class ItecXpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItecXpApiApplication.class, args);
	}

}
