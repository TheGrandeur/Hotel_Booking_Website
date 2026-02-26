package com.example.user.service;

import com.example.user.dto.BookingRequestDTO;
import com.example.user.dto.BookingResponseDTO;

public interface BookingService {

    BookingResponseDTO createBooking(BookingRequestDTO request);
}