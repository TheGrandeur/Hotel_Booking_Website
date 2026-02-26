package com.example.hotel.service;

import com.example.hotel.dto.HotelRequestDTO;
import com.example.hotel.dto.HotelResponseDTO;
import com.example.hotel.dto.RoomResponseDTO;
import com.example.hotel.exception.ResourceNotFoundException;
import com.example.hotel.model.Hotel;
import com.example.hotel.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    // Constructor Injection
    public HotelServiceImpl(HotelRepository hotelRepository, ModelMapper modelMapper) {
        this.hotelRepository = hotelRepository;
        this.modelMapper = modelMapper;
    }

    // ✅ CREATE
    @Override
    public HotelResponseDTO createHotel(HotelRequestDTO request) {

        Hotel hotel = modelMapper.map(request, Hotel.class);

        if (hotel.getRooms() != null) {
            hotel.getRooms().forEach(room -> room.setHotel(hotel));
        }

        Hotel saved = hotelRepository.save(hotel);

        return convertToResponse(saved);
    }

    // ✅ GET ALL
    @Override
    public List<HotelResponseDTO> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // ✅ GET BY ID
    @Override
    public HotelResponseDTO getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        return convertToResponse(hotel);
    }

    // ✅ SEARCH
    @Override
    public List<HotelResponseDTO> searchByLocation(String location) {
        return hotelRepository.findByLocationContainingIgnoreCase(location)
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // ✅ UPDATE
    @Override
    public HotelResponseDTO updateHotel(Long id, HotelRequestDTO request) {

        Hotel existing = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        existing.setName(request.getName());
        existing.setLocation(request.getLocation());
        existing.setAmenities(request.getAmenities());

        // Optional: update rooms if provided
        if (request.getRooms() != null) {
            existing.getRooms().clear();
            request.getRooms().forEach(roomDTO -> {
                var room = modelMapper.map(roomDTO, com.example.hotel.model.Room.class);
                room.setHotel(existing);
                existing.getRooms().add(room);
            });
        }

        Hotel updated = hotelRepository.save(existing);

        return convertToResponse(updated);
    }

    // ✅ DELETE
    @Override
    public void deleteHotel(Long id) {

        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id: " + id));

        hotelRepository.delete(hotel);
    }

    // ✅ CONVERTER
    private HotelResponseDTO convertToResponse(Hotel hotel) {

        List<RoomResponseDTO> rooms = hotel.getRooms() == null
                ? List.of()
                : hotel.getRooms()
                .stream()
                .map(r -> new RoomResponseDTO(
                        r.getId(),
                        r.getCategory(),
                        r.getPrice(),
                        r.getAvailableRooms()
                ))
                .collect(Collectors.toList());

        return new HotelResponseDTO(
                hotel.getId(),
                hotel.getName(),
                hotel.getLocation(),
                hotel.getAmenities(),
                rooms
        );
    }
}