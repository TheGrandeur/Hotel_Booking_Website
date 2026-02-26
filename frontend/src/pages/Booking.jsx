import { useState } from "react";
import { createUser, createBooking } from "../services/api";

function Booking() {
  const [user, setUser] = useState({
    name: "",
    surname: "",
    email: "",
    phone: ""
  });

  const [booking, setBooking] = useState({
    userId: "",
    hotelId: "",
    roomId: "",
    roomsBooked: 1
  });

  const handleUserSubmit = async (e) => {
    e.preventDefault(); // 🔥 prevent page reload
    try {
      const res = await createUser(user);
      alert("User Created! ID: " + res.data.id);
    } catch (err) {
      alert("Error creating user");
    }
  };

  const handleBookingSubmit = async (e) => {
    e.preventDefault(); // 🔥 prevent page reload
    try {
      await createBooking(booking);
      alert("Booking Successful!");
    } catch (err) {
      alert("Booking Failed");
    }
  };

  return (
    <div style={{ padding: "1rem" }}>
      <h2>Create User</h2>

      <form onSubmit={handleUserSubmit}>
            <input
            placeholder="Name"
            value={user.name}
            onChange={e => setUser({ ...user, name: e.target.value })}
            />

         <input
            placeholder="Surname"
            value={user.surname}
            onChange={e => setUser({ ...user, surname: e.target.value })}
            />
        <input
          placeholder="Email"
          value={user.email}
          onChange={e => setUser({ ...user, email: e.target.value })}
        />
        <input
          placeholder="Phone"
          value={user.phone}
          onChange={e => setUser({ ...user, phone: e.target.value })}
        />
        <button type="submit">Create User</button>
      </form>

      <h2>Book Room</h2>

      <form onSubmit={handleBookingSubmit}>
        <input
          placeholder="User ID"
          value={booking.userId}
          onChange={e => setBooking({ ...booking, userId: e.target.value })}
        />
        <input
          placeholder="Hotel ID"
          value={booking.hotelId}
          onChange={e => setBooking({ ...booking, hotelId: e.target.value })}
        />
        <input
          placeholder="Room ID"
          value={booking.roomId}
          onChange={e => setBooking({ ...booking, roomId: e.target.value })}
        />
        <input
          type="number"
          placeholder="Rooms to Book"
          value={booking.roomsBooked}
          onChange={e => setBooking({ ...booking, roomsBooked: e.target.value })}
        />
        <button type="submit">Book Now</button>
      </form>
    </div>
  );
}

export default Booking;