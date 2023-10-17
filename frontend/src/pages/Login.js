import React from "react";

function Login() {
  return (
    <section
      id="book-a-table"
      className="book-a-table  "
      style={{ marginTop: "150px", marginBottom: "150px" }}
    >
      <div className="container" data-aos="fade-up">
        <div className="section-title">
          <h2>GustoFusion</h2>
          <p>Login</p>
        </div>

        <form
          action="forms/book-a-table.php"
          method="post"
          role="form"
          className="php-email-form"
          data-aos="fade-up"
          data-aos-delay={100}
        >
          <div className="row mx-auto " style={{ width: "40%" }}>
            <label
              htmlFor="name"
              className="ms-2 my-3 "
              style={{ textAlign: "left" }}
            >
              Email
            </label>
            <div className=" form-group mt-3 mt-md-0">
              <input
                type="email"
                className="form-control"
                name="email"
                id="email"
                placeholder="Your Email"
                data-rule="email"
                data-msg="Please enter a valid email"
              />
              <div className="validate" />
            </div>

            <label
              htmlFor="name"
              className="ms-2 my-3 "
              style={{ textAlign: "left" }}
            >
              Password
            </label>
            <div className=" form-group mt-3 mt-md-0">
              <input
                type="password"
                className="form-control"
                name="password"
                id="password"
                placeholder="Password"
                data-rule="minlen:4"
                data-msg="Please enter at least 4 chars"
              />
              <div className="validate" />
            </div>
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
            <button type="submit">Login</button>
          </div>
        </form>
      </div>
    </section>
  );
}

export default Login;
