import React from "react";

const TableCard = ({ table }) => {
  return (
    <div className="col-md-6">
      <div className="card flex-md-row mb-4 shadow-sm h-md-250">
        <div className="card-body d-flex flex-column align-items-start">
          <strong className="d-inline-block mb-2 text-primary">World</strong>
          <h6 className="mb-0">
            <a className="text-dark" href="#">
              40 Percent of People Can’t Afford Basics
            </a>
          </h6>
          <div className="mb-1 text-muted small">Nov 12</div>
          <p className="card-text mb-auto">
            This is a wider card with supporting text below as a natural lead-in
            to additional content.
          </p>
          <a
            className="btn btn-outline-primary btn-sm"
            role="button"
            href="http://www.jquery2dotnet.com/"
          >
            Continue reading
          </a>
        </div>
        <img
          className="card-img-right flex-auto d-none d-lg-block"
          alt="Thumbnail [200x250]"
          src="//placeimg.com/250/250/arch"
          style={{ width: 200, height: 250 }}
        />
      </div>
    </div>
  );
};

export default TableCard;
