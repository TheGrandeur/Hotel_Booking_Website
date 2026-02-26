package com.example.hotel.controller;

import com.example.hotel.dto.HotelRequestDTO;
import com.example.hotel.dto.HotelResponseDTO;
import com.example.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:5173")
public class HotelController {

    private final HotelService hotelService;

    // Constructor Injection
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // ✅ CREATE HOTEL
    @PostMapping
    public ResponseEntity<HotelResponseDTO> createHotel(
            @RequestBody HotelRequestDTO request) {

        HotelResponseDTO response = hotelService.createHotel(request);
        return ResponseEntity.status(201).body(response);
    }

    // ✅ GET ALL HOTELS
    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> getAllHotels() {

        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    // ✅ GET HOTEL BY ID
    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> getHotelById(
            @PathVariable Long id) {

        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    // ✅ UPDATE HOTEL
    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> updateHotel(
            @PathVariable Long id,
            @RequestBody HotelRequestDTO request) {

        return ResponseEntity.ok(hotelService.updateHotel(id, request));
    }

    // ✅ DELETE HOTEL
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(
            @PathVariable Long id) {

        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel deleted successfully");
    }

    // ✅ SEARCH BY LOCATION
    @GetMapping("/search")
    public ResponseEntity<List<HotelResponseDTO>> searchByLocation(
            @RequestParam String location) {

        return ResponseEntity.ok(hotelService.searchByLocation(location));
    }
}