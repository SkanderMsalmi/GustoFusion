import React from "react";
import { Link } from 'react-router-dom';

function SideBarAdmin() {
  return (
    <div
      className="p-4"
      style={{ minHeight: "100vh", backgroundColor: "white" }}
    >
      {/* <div className="mb-5">Tables</div> */}
      <ul className="nav  flex-column">
        <li className="nav-item text-dark">
          <a className="nav-link text-dark " data-bs-toggle="tab" href="#tab-2">
            Clients
          </a>
        </li>
        <li className="nav-item">
          <a className="nav-link text-dark" data-bs-toggle="tab" href="#tab-2">
            Reservations
          </a>
        </li>
        <li className="nav-item">
          <a className="nav-link text-dark" data-bs-toggle="tab" href="#tab-3">
            Tables
          </a>
        </li>
        <li className="nav-item">
  <Link to="/admin/menu" className="nav-link text-dark">
    Menu
  </Link>
</li>
      </ul>
    </div>
  );
}

export default SideBarAdmin;
