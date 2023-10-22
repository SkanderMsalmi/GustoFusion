/* eslint-disable jsx-a11y/no-redundant-roles */
import React from "react";

function AddReservationPersonel() {
  return (
    <section id="book-a-table" className="book-a-table main-div">
      <div className="container" data-aos="fade-up">
        <div className="section-title">
          <h2>Reservation</h2>
          <p>Add Reservation</p>
        </div>

        <form
          action="forms/book-a-table.php"
          method="post"
          role="form"
          className="php-email-form"
          data-aos="fade-up"
          data-aos-delay={100}
        >
          <div className="row">
            <div className="col-lg-4 col-md-6 form-group">
              <input
                type="text"
                name="name"
                className="form-control"
                id="name"
                placeholder=" Name Client"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>

            <div className="col-lg-4 col-md-6 form-group mt-3 mt-md-0">
              <input
                type="text"
                className="form-control"
                name="phone"
                id="phone"
                placeholder="Phone Client"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3 mt-md-0">
              <input
                type="text"
                name="date"
                className="form-control"
                id="date"
                placeholder="Date"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3">
              <input
                type="text"
                className="form-control"
                name="time"
                id="time"
                placeholder="Time"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
            <div className="col-lg-4 col-md-6 form-group mt-3">
              <input
                type="text"
                className="form-control"
                name="time"
                id="time"
                placeholder="Time"
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
              name="note"
              rows={5}
              placeholder="Note"
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
            <button type="submit">Save Reservation</button>
          </div>
        </form>
      </div>
    </section>
  );
}

export default AddReservationPersonel;
