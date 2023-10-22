import React from "react";
import SearchFilters from "../../../shared/SearchFilters";

function ReservationsTable() {
  const title = "Reservation";
  return (
    <div className="text-dark p-5">
      <SearchFilters title={title} />
      <table class="table mt-5">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Customer </th>
            <th scope="col">Status</th>
            <th scope="col">Phone</th>
            <th scope="col">Confirmation Code</th>
            <th scope="col">Table Number</th>
            <th scope="col">Start Time</th>
            <th scope="col">End Time</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>
              <button className="btn btn-danger">X</button>
            </td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>
              <button className="btn btn-danger">X</button>
            </td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>Otto</td>
            <td>@mdo</td>
            <td>Mark</td>
            <td>
              <button className="btn btn-danger">X</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default ReservationsTable;
