package com.example.hotel.dto;

import java.util.List;

public class HotelRequestDTO {

    private String name;
    private String location;
    private String amenities;
    private List<RoomRequestDTO> rooms;

    // Constructors
    public HotelRequestDTO() {
    }

    public HotelRequestDTO(String name, String location, String amenities, List<RoomRequestDTO> rooms) {
        this.name = name;
        this.location = location;
        this.amenities = amenities;
        this.rooms = rooms;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAmenities() {
        return amenities;
    }

    public List<RoomRequestDTO> getRooms() {
        return rooms;
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

    public void setRooms(List<RoomRequestDTO> rooms) {
        this.rooms = rooms;
    }
}