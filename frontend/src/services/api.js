import axios from "axios";

const HOTEL_API = "http://localhost:8081/api/hotels";
const USER_API = "http://localhost:8082/api/users";
const BOOKING_API = "http://localhost:8082/api/bookings";

export const getHotels = () => axios.get(HOTEL_API);

export const createUser = (data) => axios.post(USER_API, data);

export const createBooking = (data) => axios.post(BOOKING_API, data);