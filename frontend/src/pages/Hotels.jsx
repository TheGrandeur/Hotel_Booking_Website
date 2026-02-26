import { useEffect, useState } from "react";
import { getHotels } from "../services/api";

function Hotels() {
  const [hotels, setHotels] = useState([]);

  useEffect(() => {
    getHotels().then(res => setHotels(res.data));
  }, []);

  return (
    <div style={{ padding: "1rem" }}>
      <h2>Available Hotels</h2>
      {hotels.map(hotel => (
        <div key={hotel.id} style={styles.card}>
          <h3>{hotel.name}</h3>
          <p>Location: {hotel.location}</p>
          <p>Amenities: {hotel.amenities}</p>
          <h4>Rooms:</h4>
          {hotel.rooms.map(room => (
            <div key={room.id}>
              {room.category} - ₹{room.price} - Available: {room.availableRooms}
            </div>
          ))}
        </div>
      ))}
    </div>
  );
}

const styles = {
  card: {
    border: "1px solid #ccc",
    padding: "1rem",
    marginBottom: "1rem",
    borderRadius: "8px"
  }
};

export default Hotels;