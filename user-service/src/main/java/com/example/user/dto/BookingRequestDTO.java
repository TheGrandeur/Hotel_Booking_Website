package com.example.user.dto;

public class BookingRequestDTO {

    private Long userId;
    private Long hotelId;
    private Long roomId;
    private Integer roomsBooked;

    public BookingRequestDTO() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(Integer roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

    // getters and setters
}