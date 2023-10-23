import React, { useEffect, useState } from "react";
import ReservationService from "../../../../services/ReservationService";
import "./ListReservation.css";
import ReservationCard from "./ReservationCard";
function ListReservation() {
  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    ReservationService.getReservations().then((result) => {
      console.log(result.data);
      setReservations(result.data);
    });
  }, []);
  return (
    <div className="container main-div" data-aos="fade-up">
      <div className="d-flex justify-content-between align-items-center">
        <div className="section-title">
          <h2>Reservation</h2>
          <p>List Reservations</p>
        </div>
        <div className=" form-group  d-flex align-items-center">
          <input
            type="search"
            className="form-control"
            name="search"
            id="search"
            placeholder="Search"
            data-rule="search"
            data-msg="Please enter a valid search"
          />
          <i class="fa-solid fa-magnifying-glass fa-xl mx-2"></i>
          <i class="fa-solid fa-filter fa-xl mx-2"></i>
          <div className="validate" />
        </div>
      </div>
      <div className="row">
        {reservations.map((reservation) => (
          <ReservationCard key={reservation.id} reservation={reservation} />
        ))}
      </div>
    </div>
  );
}

export default ListReservation;
