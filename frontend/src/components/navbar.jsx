import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav style={styles.nav}>
      <h2>Hotel Booking</h2>
      <div>
        <Link to="/">Home</Link>{" | "}
        <Link to="/hotels">Hotels</Link>{" | "}
        <Link to="/booking">Book</Link>
      </div>
    </nav>
  );
}

const styles = {
  nav: {
    display: "flex",
    justifyContent: "space-between",
    padding: "1rem",
    background: "#282c34",
    color: "white"
  }
};

export default Navbar;