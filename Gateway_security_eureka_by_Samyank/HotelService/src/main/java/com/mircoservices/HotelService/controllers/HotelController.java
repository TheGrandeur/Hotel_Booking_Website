package com.mircoservices.HotelService.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mircoservices.HotelService.entities.Hotel;
import com.mircoservices.HotelService.services.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create

    
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        
          return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }


    //get single
    
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> createHotel(@PathVariable Long hotelId) {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }


    //get all
    
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }


}
