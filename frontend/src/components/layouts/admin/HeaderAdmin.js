import React from "react";

function HeaderAdmin() {
  return (
    <div>
      <header id="header" className=" d-flex align-items-center">
        <div
          className="  d-flex align-items-center justify-content-between mx-auto"
          style={{ width: "90%" }}
        >
          <div>
            <h1 className="logo me-auto me-lg-0">
              <a href="index.html">
                Gusto{" "}
                <span className="active" style={{ color: "#cda45e" }}>
                  Fusion
                </span>
              </a>
            </h1>
          </div>
          {/* Uncomment below if you prefer to use an image logo */}
          {/* <a href="index.html" class="logo me-auto me-lg-0"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>*/}

          {/* .navbar */}
          <div>
            <a
              href="#book-a-table"
              className="book-a-table-btn scrollto d-none d-lg-flex"
            >
              Admin
            </a>
          </div>
        </div>
      </header>
      {/* End Header */}
      {/* <HeroSection /> */}
    </div>
  );
}

export default HeaderAdmin;
