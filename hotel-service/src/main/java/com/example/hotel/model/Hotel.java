package com.example.hotel.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String amenities;

    @JsonManagedReference
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    // Constructors
    public Hotel() {
    }

    public Hotel(Long id, String name, String location, String amenities, List<Room> rooms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.amenities = amenities;
        this.rooms = rooms != null ? rooms : new ArrayList<>();
    }

    // Utility method (VERY IMPORTANT for bidirectional mapping)
    public void addRoom(Room room) {
        rooms.add(room);
        room.setHotel(this);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
        room.setHotel(null);
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    // ✅ Missing earlier
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms.clear();
        if (rooms != null) {
            rooms.forEach(this::addRoom);
        }
    }
}