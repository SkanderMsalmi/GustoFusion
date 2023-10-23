/* eslint-disable jsx-a11y/anchor-is-valid */
import React from "react";


function Header() {
  return (
    <>
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
                    {/* ***********cart************* */}
            <a href="/cart">
            <div  className='cart-container'  >
                <i className="bi bi-cart" style={{fontSize:"30px"}}></i>
								<span className=" translate-middle badge rounded-circle bg-white text-dark">2</span>
						</div>
            </a>
                      {/* ***********!cart************** */}

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
                  <a className="nav-link scrollto active" href="#hero">
                    Home
                  </a>
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
                  <a className="nav-link scrollto" href="#events">
                    Events
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
                    <span>Drop Down</span> <i className="bi bi-chevron-down" />
                  </a>
                  <ul>
                    <li>
                      <a href="#">Drop Down 1</a>
                    </li>
                    <li className="dropdown">
                      <a href="#">
                        <span>Deep Drop Down</span>{" "}
                        <i className="bi bi-chevron-right" />
                      </a>
                      <ul>
                        <li>
                          <a href="#">Deep Drop Down 1</a>
                        </li>
                        <li>
                          <a href="#">Deep Drop Down 2</a>
                        </li>
                        <li>
                          <a href="#">Deep Drop Down 3</a>
                        </li>
                        <li>
                          <a href="#">Deep Drop Down 4</a>
                        </li>
                        <li>
                          <a href="#">Deep Drop Down 5</a>
                        </li>
                      </ul>
                    </li>
                    <li>
                      <a href="#">Drop Down 2</a>
                    </li>
                    <li>
                      <a href="#">Drop Down 3</a>
                    </li>
                    <li>
                      <a href="#">Drop Down 4</a>
                    </li>
                  </ul>
                </li>
                <li>
                  <a className="nav-link scrollto" href="#contact">
                    Contact
                  </a>
                </li>
              </ul>
              <i className="bi bi-list mobile-nav-toggle" />
            </nav>
            {/* .navbar */}
            <a
              href="#book-a-table"
              className="book-a-table-btn scrollto d-none d-lg-flex"
            >
              Book a table
            </a>
          </div>
        </header>
        {/* End Header */}
        {/* <HeroSection /> */}
      </div>
    </>
  );
}

export default Header;
