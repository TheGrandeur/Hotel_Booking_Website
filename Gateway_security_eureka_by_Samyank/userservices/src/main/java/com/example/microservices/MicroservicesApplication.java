package com.example.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
//	<dependency>
//    <groupId>org.springframework.boot</groupId>
//    <artifactId>spring-boot-devtools</artifactId>
//    <scope>runtime</scope>
//</dependency>


}
