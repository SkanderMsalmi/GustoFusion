import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function SousChefs() {
  const [sousChefs, setSousChefs] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8083/api/sous-chef")
      .then(response => {
        setSousChefs(response.data);
      })
      .catch(error => {
        console.log(error);
      });
      
  }, []);

  useEffect(() => {
    console.log(sousChefs);
  }, [sousChefs]);

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8083/api/sous-chef/${id}`)
      .then(response => {
        console.log(response.data);
        // Update the state to remove the deleted sous chef
        setSousChefs(sousChefs.filter(sousChef => sousChef.id !== id));
      })
      .catch(error => {
        console.log(error);
      });
  }

  return (
    <div className="container">
      <div className="d-flex justify-content-between align-items-baseline">
        <div className="d-flex justify-content-between align-items-center">
          <div>
            <h1 style={{color: "black"}}>Sous Chefs</h1>
          </div>
          <div>
            <div className=" form-group  d-flex align-items-center" style={{color: "black"}}>
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
              <i class="fa-solid fa-filter fa-xl mx-2" ></i>
              <div className="validate" />
            </div>
          </div>
        </div>

        <Link to="create">
          <button className="btn btn-success mb-3 float-right">
            <i class="fa fa-plus" aria-hidden="true"></i>
          </button>
        </Link>
      </div>

      <table className="table">
        <thead>
          <tr>
            <th>Badge #</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Salary</th>
            <th>Type of Service</th>
            <th>Chef</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {sousChefs.map(sousChef => (
            <tr key={sousChef.id}>
              <td>{sousChef.badge}</td>
              <td>{sousChef.prenom}</td>
              <td>{sousChef.nom}</td>
              <td>{sousChef.salaire}</td>
              <td>{sousChef.typeService}</td>
              <td>{sousChef.chef.nom}</td>
              <td>
                <Link to={"edit/"+sousChef.id}><button className="btn btn-primary mr-2">Edit</button></Link>
                <button onClick={() => handleDelete(sousChef.id)} className="btn btn-danger">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default SousChefs;