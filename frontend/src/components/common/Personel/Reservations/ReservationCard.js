import React from "react";

const ReservationCard = ({ reservation }) => {
  return (
    <div class="col-xs-12 col-sm-6 col-md-4">
      <div class="image-flip">
        <div class="mainflip flip-0">
          <div class="frontside">
            <div class="card text-dark">
              <div class="card-body text-center ">
                <h4 class="card-title">{reservation.customerName}</h4>
                <p class="card-text">
                  <span> Special Request: </span> {reservation.specialRequests}
                </p>
                <p>Time</p>
                <p>{reservation.reservationStartDateTime}</p>
                <p>{reservation.reservationEndDateTime}</p>
              </div>
              <div className="card-footer w-100 text-center">
                <span>{reservation.reservationDateTime}</span>
              </div>
            </div>
          </div>
          <div class="backside w-100">
            <div class="card">
              <div class="card-body text-center mt-4 text-dark">
                <h4 class="card-title">Details</h4>
                <p class="card-text">
                  <p>Table:{reservation.table.seatingCapacity}</p>
                  <p>Status:{reservation.status}</p>
                  <p>Phone: 27 434 026</p>
                  <p>Location:{reservation.table.location}</p>
                </p>
                <ul class="list-inline">
                  <li class="list-inline-item">
                    <button className="btn btn-primary">Confirmer</button>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ReservationCard;
