import React, { useEffect, useState } from "react";
// import TableService from "../../../../services/TableService";
import TableCard from "./TableCard";
function ListTable() {
  //   const [Tables, setTables] = useState([]);

  //   useEffect(() => {
  //     TableService.getTables().then((result) => {
  //       console.log(result.data);
  //       setTables(result.data);
  //     });
  //   }, []);
  return (
    <div className="container main-div" data-aos="fade-up">
      <div className="d-flex justify-content-between align-items-center">
        <div className="section-title">
          <h2>Tables</h2>
          <p>Our Tables</p>
        </div>
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
      <div className="row">
        {[1, 2, 3].map((Table) => (
          <TableCard key={Table.id} table={null} />
        ))}
      </div>
    </div>
  );
}

export default ListTable;
