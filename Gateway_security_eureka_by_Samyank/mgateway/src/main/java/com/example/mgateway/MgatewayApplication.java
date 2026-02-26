package com.example.mgateway;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

import com.example.mgateway.filter.JwtFilter;

@SpringBootApplication
public class MgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MgatewayApplication.class, args);
	}
	
	 @Bean
	   public GlobalFilter customFilter() {
	        return new JwtFilter();
	    }

}
