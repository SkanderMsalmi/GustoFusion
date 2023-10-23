import React from "react";
import { Link } from "react-router-dom";

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
        <li className="nav-item text-dark">
          <span className="nav-link text-dark " data-bs-toggle="tab" href="#tab-2">
            Employés
          </span>
        <ul className="nav  flex-column "style={{marginLeft:"1rem"}}>
        <li className="nav-item text-dark">
          <Link to="/admin/employees/chefs" className="nav-link text-dark ">
            Chefs
          </Link>
        </li>
        <li className="nav-item text-dark">
        <Link to="/admin/employees/sousChefs"  className="nav-link text-dark "  >
            Sous-Chefs
          </Link>
        </li>
        <li className="nav-item text-dark">
        <Link to="/admin/employees/livreurs"  className="nav-link text-dark " >
            Delivery men
          </Link>
        </li>
        </ul>
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
      </ul>
    </div>
  );
}

export default SideBarAdmin;
