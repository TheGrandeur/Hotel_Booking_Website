package com.mircoservices.HotelService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mircoservices.HotelService.entities.Hotel;
import com.mircoservices.HotelService.exceptions.ResourceNotFoundExceptions;
import com.mircoservices.HotelService.repositories.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel get(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("hotel with given id not found !!"));
    }
}
