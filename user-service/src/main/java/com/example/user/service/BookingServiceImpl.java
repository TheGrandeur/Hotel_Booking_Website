package com.example.user.service;

import com.example.user.dto.*;
import com.example.user.model.Booking;
import com.example.user.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              RestTemplate restTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO request) {

        // 1️⃣ Check if user exists
        restTemplate.getForObject(
                "http://localhost:8082/api/users/" + request.getUserId(),
                Object.class
        );

        // 2️⃣ Check if hotel exists
        restTemplate.getForObject(
                "http://localhost:8081/api/hotels/" + request.getHotelId(),
                Object.class
        );

        // TODO: Add room availability check later

        Booking booking = new Booking(
                null,
                request.getUserId(),
                request.getHotelId(),
                request.getRoomId(),
                request.getRoomsBooked()
        );

        Booking saved = bookingRepository.save(booking);

        return new BookingResponseDTO(
                saved.getId(),
                saved.getUserId(),
                saved.getHotelId(),
                saved.getRoomId(),
                saved.getRoomsBooked()
        );
    }
}