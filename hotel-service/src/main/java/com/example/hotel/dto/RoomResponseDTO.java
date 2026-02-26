package com.example.hotel.dto;

public class RoomResponseDTO {

    private Long id;
    private String category;
    private Double price;
    private Integer availableRooms;

    // Constructors
    public RoomResponseDTO() {
    }

    public RoomResponseDTO(Long id, String category, Double price, Integer availableRooms) {
        this.id = id;
        this.category = category;
        this.price = price;
        this.availableRooms = availableRooms;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }
}