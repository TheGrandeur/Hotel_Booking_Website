package com.example.user.dto;

public class BookingResponseDTO {

    private Long bookingId;
    private Long userId;
    private Long hotelId;
    private Long roomId;
    private Integer roomsBooked;

    public BookingResponseDTO() {}

    public BookingResponseDTO(Long bookingId, Long userId,
                              Long hotelId, Long roomId,
                              Integer roomsBooked) {
        this.setBookingId(bookingId);
        this.setUserId(userId);
        this.setHotelId(hotelId);
        this.setRoomId(roomId);
        this.setRoomsBooked(roomsBooked);
    }

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

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

    
}