import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import { useParams } from 'react-router';

function Chefs() {
  const [chefs, setChefs] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const params= useParams()
  
  useEffect(() => {
    axios.get("http://localhost:8083/api/chef")
      .then(response => {
        setChefs(response.data);
        console.log(params.search)
        if (params.search) {
          setSearchTerm(params.search);
        }
      })
      .catch(error => {
        console.log(error);
      });
    
  }, []);

  useEffect(() => {
    console.log(chefs);
  }, [chefs]);
  const handleDelete = (id) => {
    axios.delete(`http://localhost:8083/api/chef/${id}`)
      .then(response => {
        console.log(response.data);
        // Update the state to remove the deleted chef
        setChefs(chefs.filter(chef => chef.id !== id));
      })
      .catch(error => {
        console.log(error);
      });
  }
  const filteredChefs = chefs.filter((chef) =>
  chef.nom.toLowerCase().includes(searchTerm.toLowerCase()) ||
  chef.prenom.toLowerCase().includes(searchTerm.toLowerCase())
);
  return (
    <div className="container">
        <div className="d-flex justify-content-between align-items-baseline align-items-center">

      <div>
        <h1 style={{color: "black"}}>Chefs</h1>
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
          <i class="fa-solid fa-filter fa-xl mx-2" ></i>
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
    <th>Name</th>
    <th>Lastname</th>
    <th>Salary</th>
    <th>Specialty</th>
    <th>Actions</th>
  </tr>
</thead>
<tbody>
{filteredChefs.map(chef => (
            <tr key={chef.id}>
              <td>{chef.badge}</td>
              <td>{chef.prenom}</td>
              <td>{chef.nom}</td>
              <td>{chef.salaire}</td>
              <td>{chef.specialite}</td>
              <td>
                <Link to={"edit/"+chef.id}><button className="btn btn-primary mr-2">Edit</button></Link>
                <button onClick={() => handleDelete(chef.id)} className="btn btn-danger">Delete</button>
              </td>
            </tr>
          ))}

</tbody>
    </table>
  </div>
  );
}

export default Chefs;