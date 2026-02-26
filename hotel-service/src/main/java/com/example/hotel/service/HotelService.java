package com.example.hotel.service;

import com.example.hotel.dto.HotelRequestDTO;
import com.example.hotel.dto.HotelResponseDTO;

import java.util.List;

public interface HotelService {

    HotelResponseDTO createHotel(HotelRequestDTO request);

    List<HotelResponseDTO> getAllHotels();

    HotelResponseDTO getHotelById(Long id);

    List<HotelResponseDTO> searchByLocation(String location);

    // ✅ ADD THESE
    HotelResponseDTO updateHotel(Long id, HotelRequestDTO request);

    void deleteHotel(Long id);
}