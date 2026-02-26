package com.example.user.controller;

import com.example.user.dto.*;
import com.example.user.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public BookingResponseDTO createBooking(
            @RequestBody BookingRequestDTO request) {
        return bookingService.createBooking(request);
    }
}