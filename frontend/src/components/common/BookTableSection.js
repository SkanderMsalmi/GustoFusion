/* eslint-disable jsx-a11y/no-redundant-roles */
import axios from "axios";
import React, { useState } from "react";

function BookTableSection() {
  const [formData, setFormData] = useState({
    reservationStartDateTime: "",
    reservationEndDateTime: "",
    status: "PENDING",
    customerName: "",
    contactInformation: "",
    specialRequests: "",
    tableId: 1,
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const response = axios.post(
      "http://localhost:8088/api/reservation/reservation/1/reservations",
      JSON.stringify(formData),
      {
        headers: {
          "Content-Type": "application/json",
        },
      }
    );

    if ((await response).status === 201) {
      console.log("succes");
    } else {
      console.log("error");
    }
  };
  return (
    <section id="book-a-table" className="book-a-table main-div">
      <div className="container" data-aos="fade-up">
        <div className="section-title">
          <h2>Reservation</h2>
          <p>Book a Table</p>
        </div>

        <form role="form" className="php-email-form" onSubmit={handleSubmit}>
          <div className="row">
            <div className="col-lg-4 col-md-6 form-group">
              <input
                type="text"
                name="customerName"
                className="form-control"
                id="customerName"
                value={formData.customerName}
                onChange={handleInputChange}
                placeholder="Your Name"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3 mt-md-0">
              <input
                type="email"
                className="form-control"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleInputChange}
                placeholder="Your Email"
                data-rule="email"
                data-msg="Please enter a valid email"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3 mt-md-0">
              <input
                type="tel"
                className="form-control"
                id="phone"
                name="phone"
                value={formData.phone}
                onChange={handleInputChange}
                placeholder="Your Phone"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3">
              <input
                type="datetime-local"
                className="form-control"
                id="reservationStartDateTime"
                name="reservationStartDateTime"
                value={formData.reservationStartDateTime}
                onChange={handleInputChange}
                style={{ color: "#918c82" }}
                placeholder="Date"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3">
              <input
                type="datetime-local"
                className="form-control"
                style={{ color: "#918c82" }}
                id="reservationEndDateTime"
                name="reservationEndDateTime"
                value={formData.reservationEndDateTime}
                onChange={handleInputChange}
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>

            <div className="col-lg-4 col-md-6 form-group mt-3">
              <input
                type="number"
                className="form-control"
                name="people"
                id="people"
                placeholder="# of people"
                data-rule="minlen:1"
                data-msg="Please enter at least 1 chars"
              />
              <div className="validate" />
            </div>
          </div>
          <div className="form-group mt-3">
            <textarea
              className="form-control"
              id="specialRequests"
              name="specialRequests"
              value={formData.specialRequests}
              onChange={handleInputChange}
              rows={5}
              placeholder="Any Special Requests"
              defaultValue={""}
            />
            <div className="validate" />
          </div>
          <div className="mb-3">
            <div className="loading">Loading</div>
            <div className="error-message" />
            <div className="sent-message">
              Your booking request was sent. We will call back or send an Email
              to confirm your reservation. Thank you!
            </div>
          </div>
          <div className="text-center">
            <button type="submit">Book a Table</button>
          </div>
        </form>
      </div>
    </section>
  );
}

export default BookTableSection;
