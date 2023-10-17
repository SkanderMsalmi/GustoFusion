import "./App.css";
import BookTableSection from "./components/common/BookTableSection";
import AddReservationPersonel from "./components/common/Personel/Reservations/AddReservationPersonel";
import Footer from "./components/layouts/Footer";
import Header from "./components/layouts/Header";
import Admin from "./pages/Admin";
import Client from "./pages/Client";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";
// import Reservation from "./pages/Reservation";

function App() {
  return (
    <div className="App">
      <Client />
    </div>
  );
}

export default App;
