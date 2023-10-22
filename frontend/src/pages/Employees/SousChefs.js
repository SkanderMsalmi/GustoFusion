import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function SousChefs() {
  const [sousChefs, setSousChefs] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  useEffect(() => {
    axios.get("http://localhost:8083/api/sous-chef")
      .then(response => {
        setSousChefs(response.data);
      })
      .catch(error => {
        console.log(error);
      });
      
  }, []);



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
  const filteredSousChefs = sousChefs.filter((sousChef) =>
    sousChef.nom.toLowerCase().includes(searchTerm.toLowerCase()) ||
    sousChef.prenom.toLowerCase().includes(searchTerm.toLowerCase())
  );
  return (
    <div className="container">
      <div className="d-flex justify-content-between align-items-baseline align-items-center">
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
                value={searchTerm}
              onChange={(event) => setSearchTerm(event.target.value)}
              />
              <i class="fa-solid fa-magnifying-glass fa-xl mx-2"></i>
                <i class="fa-solid fa-filter fa-xl mx-2" style={{cursor:"pointer", color: "black"}} 
                onMouseOver={(event) => event.target.style.color = "rgb(205, 164, 94)"}
                onMouseOut={(event) => event.target.style.color = "black"}
                onClick={()=>setSearchTerm("")}></i>
                <div className="validate" />
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
          {filteredSousChefs.map(sousChef => (
            <tr key={sousChef.id}>
              <td>{sousChef.badge}</td>
              <td>{sousChef.prenom}</td>
              <td>{sousChef.nom}</td>
              <td>{sousChef.salaire}</td>
              <td>{sousChef.typeService}</td>
              <td>
                <Link to={`/admin/employees/chefs/`+sousChef.chef.nom}>
                  {sousChef.chef.nom}
                </Link>
              </td>
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