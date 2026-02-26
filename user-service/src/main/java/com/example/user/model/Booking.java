package com.example.user.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long hotelId;
    private Long roomId;
    private Integer roomsBooked;

    public Booking() {}

    public Booking(Long id, Long userId, Long hotelId,
                   Long roomId, Integer roomsBooked) {
        this.id = id;
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.roomsBooked = roomsBooked;
    }

    // ✅ ADD THESE GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public Integer getRoomsBooked() {
        return roomsBooked;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public void setRoomsBooked(Integer roomsBooked) {
        this.roomsBooked = roomsBooked;
    }
}