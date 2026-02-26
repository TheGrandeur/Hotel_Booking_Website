package com.example.hotel.dto;

import java.util.List;

public class HotelResponseDTO {

    private Long id;
    private String name;
    private String location;
    private String amenities;
    private List<RoomResponseDTO> rooms;

    // Constructors
    public HotelResponseDTO() {
    }

    public HotelResponseDTO(Long id, String name, String location, String amenities, List<RoomResponseDTO> rooms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.amenities = amenities;
        this.rooms = rooms;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAmenities() {
        return amenities;
    }

    public List<RoomResponseDTO> getRooms() {
        return rooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public void setRooms(List<RoomResponseDTO> rooms) {
        this.rooms = rooms;
    }
}