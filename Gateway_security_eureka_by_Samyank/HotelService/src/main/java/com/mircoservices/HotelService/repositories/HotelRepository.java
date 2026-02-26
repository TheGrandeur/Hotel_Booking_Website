package com.mircoservices.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mircoservices.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
