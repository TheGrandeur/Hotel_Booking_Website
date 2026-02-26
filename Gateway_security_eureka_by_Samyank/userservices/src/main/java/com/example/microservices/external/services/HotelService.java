package com.example.microservices.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.microservices.entities.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

	@GetMapping("/hotels/{hotelId}")
	Hotel getHotel(@PathVariable("hotelId")  Long hotelId);
	
}
