package com.example.hotel.dto;

public class RoomRequestDTO {

    private String category;
    private Double price;
    private Integer availableRooms;

    // Constructors
    public RoomRequestDTO() {
    }

    public RoomRequestDTO(String category, Double price, Integer availableRooms) {
        this.category = category;
        this.price = price;
        this.availableRooms = availableRooms;
    }

    // Getters & Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }
}