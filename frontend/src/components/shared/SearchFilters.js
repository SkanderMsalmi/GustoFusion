import React from "react";

function SearchFilters({ title }) {
  return (
    <div className="d-flex justify-content-between align-items-center">
      <div>
        <h1>{title}</h1>
      </div>
      <div>
        <div className=" form-group  d-flex align-items-center">
          <input
            type="search"
            className="form-control"
            name="search"
            id="search"
            placeholder="Search"
            data-rule="search"
            data-msg="Please enter a valid search"
          />
          <i class="fa-solid fa-magnifying-glass fa-xl mx-2"></i>
          <i class="fa-solid fa-filter fa-xl mx-2"></i>
          <div className="validate" />
        </div>
      </div>
    </div>
  );
}

export default SearchFilters;
