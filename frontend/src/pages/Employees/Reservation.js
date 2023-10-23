import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { useParams } from "react-router";

function Reservations() {
  const [reservations, setReservations] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  useEffect(() => {
    axios
      .get("http://localhost:8088/api/reservation/reservation")
      .then((response) => {
        setReservations(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    console.log(reservations);
  }, [reservations]);
  const handleDelete = (id) => {
    axios
      .delete(`http://localhost:8088/api/reservation/reservation/${id}`)
      .then((response) => {
        console.log(response.data);
        // Update the state to remove the deleted reservation
        setReservations(
          reservations.filter((reservation) => reservation.id !== id)
        );
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const filteredReservations = reservations.filter((reservation) =>
    reservation.customerName.toLowerCase().includes(searchTerm.toLowerCase())
  );
  return (
    <div className="container">
      <div className="d-flex justify-content-between align-items-baseline align-items-center">
        <div>
          <h1 style={{ color: "black" }}>Reservations</h1>
        </div>
        <div>
          <div
            className=" form-group  d-flex align-items-center"
            style={{ color: "black" }}
          >
            <input
              type="search"
              className="form-control"
              name="search"
              id="search"
              placeholder="Search"
              value={searchTerm}
              onChange={(event) => setSearchTerm(event.target.value)}
            />
            <i class="fa-solid fa-magnifying-glass fa-xl mx-2"></i>
            <i
              class="fa-solid fa-filter fa-xl mx-2"
              style={{ cursor: "pointer", color: "black" }}
              onMouseOver={(event) =>
                (event.target.style.color = "rgb(205, 164, 94)")
              }
              onMouseOut={(event) => (event.target.style.color = "black")}
              onClick={() => setSearchTerm("")}
            ></i>{" "}
            <div className="validate" />
          </div>
        </div>

        <Link to="create">
          <button className="btn btn-success mb-3 float-right">
            <i class="fa fa-plus" aria-hidden="true"></i>
          </button>
        </Link>
      </div>
      <table className="table">
        <thead>
          <tr>
            <th>Badge #</th>
            <th>customerName</th>
            <th>reservationStartDateTime</th>
            <th>reservationEndDateTime</th>
            <th>status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredReservations.map((reservation) => (
            <tr key={reservation.id}>
              <td>{reservation.id}</td>
              <td>{reservation.customerName}</td>
              <td>{reservation.reservationStartDateTime}</td>
              <td>{reservation.reservationEndDateTime}</td>
              <td>{reservation.status}</td>
              <td>
                <Link to={"edit/" + reservation.id}>
                  <button className="btn btn-primary mr-2">Edit</button>
                </Link>
                <button
                  onClick={() => handleDelete(reservation.id)}
                  className="btn btn-danger"
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Reservations;
