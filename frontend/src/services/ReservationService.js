import axios from "axios";

const RESERVATION_API_BASE_URL =
  "http://localhost:8088/api/reservation/reservation";

class ReservationServices {
  getReservations() {
    return axios.get(RESERVATION_API_BASE_URL, {
      headers: {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
    });
  }

  setReservation() {
    return axios.post(RESERVATION_API_BASE_URL, {
      headers: {
        "Content-Type": "application/json",
      },
    });
  }
}
const ReservationService = new ReservationServices();
export default ReservationService;
