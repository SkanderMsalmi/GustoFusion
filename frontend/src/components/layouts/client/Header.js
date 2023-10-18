/* eslint-disable jsx-a11y/anchor-is-valid */
import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <div>
      <div id="topbar" className="d-flex align-items-center fixed-top">
        <div className="container d-flex justify-content-center justify-content-md-between">
          <div className="contact-info d-flex align-items-center">
            <i className="bi bi-phone d-flex align-items-center">
              <span>+216 99 099 098</span>
            </i>
            <i className="bi bi-clock d-flex align-items-center ms-4">
              <span> Mon-Sat: 11AM - 23PM</span>
            </i>
          </div>
          <div className="languages d-none d-md-flex align-items-center">
            <ul>
              <li>En</li>
              <li>
                <a href="#">De</a>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <header id="header" className="fixed-top d-flex align-items-cente">
        <div className="container-fluid container-xl d-flex align-items-center justify-content-lg-between">
          <h1 className="logo me-auto me-lg-0">
            <a href="index.html">
              Gusto{" "}
              <span className="active" style={{ color: "#cda45e" }}>
                Fusion
              </span>
            </a>
          </h1>
          {/* Uncomment below if you prefer to use an image logo */}
          {/* <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>*/}
          <nav id="navbar" className="navbar order-last order-lg-0">
            <ul>
              <li>
                <Link className="nav-link scrollto active" to={"/"}>
                  Home
                </Link>
              </li>
              <li>
                <a className="nav-link scrollto" href="#about">
                  About
                </a>
              </li>
              <li>
                <a className="nav-link scrollto" href="#menu">
                  Menu
                </a>
              </li>
              <li>
                <a className="nav-link scrollto" href="#specials">
                  Specials
                </a>
              </li>

              <li>
                <a className="nav-link scrollto" href="#chefs">
                  Chefs
                </a>
              </li>
              <li>
                <a className="nav-link scrollto" href="#gallery">
                  Gallery
                </a>
              </li>
              <li className="dropdown">
                <a href="#">
                  <span>Services</span> <i className="bi bi-chevron-down" />
                </a>
                <ul>
                  <li>
                    <Link to={"reservation"}>Book Table </Link>
                  </li>
                  <li>
                    <a href="#">Gallery</a>
                  </li>
                  <li>
                    <a href="#">Contact Us</a>
                  </li>
                </ul>
              </li>
              <li>
                <a className="nav-link scrollto" href="#contact">
                  Contact
                </a>
              </li>
              <li>
                <a className="nav-link scrollto" href="#contact">
                  Feebacks
                </a>
              </li>
            </ul>
            <i className="bi bi-list mobile-nav-toggle" />
          </nav>
          {/* .navbar */}
          <div className="d-flex">
            <Link
              to={"/login"}
              className="book-a-table-btn scrollto d-none d-lg-flex"
            >
              Login
            </Link>
            <Link
              to={"/register"}
              className="book-a-table-btn scrollto d-none d-lg-flex"
            >
              Register
            </Link>
          </div>
        </div>
      </header>
      {/* End Header */}
      {/* <HeroSection /> */}
    </div>
  );
}

export default Header;
