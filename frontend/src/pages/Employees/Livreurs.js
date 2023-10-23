import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function Livreurs() {
  const [livreurs, setLivreurs] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [disponibliteFilter, setDisponibliteFilter] = useState(false);

  useEffect(() => {
    axios.get("http://localhost:8083/api/livreur")
      .then(response => {
        setLivreurs(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const handleDelete = (id) => {
    axios.delete(`http://localhost:8083/api/livreur/${id}`)
      .then(response => {
        console.log(response.data);
        // Update the state to remove the deleted livreur
        setLivreurs(livreurs.filter(livreur => livreur.id !== id));
      })
      .catch(error => {
        console.log(error);
      });
  }
  const filteredLivreurs = livreurs.filter((livreur) =>
  (livreur.nom.toLowerCase().includes(searchTerm.toLowerCase()) ||
  livreur.prenom.toLowerCase().includes(searchTerm.toLowerCase())) &&
    (!disponibliteFilter || livreur.disponiblite)
  );
  return (
    <div className="container">
      <div className="d-flex justify-content-between align-items-baseline align-items-center">
          <div>
            <h1 style={{color: "black"}}>Delivery men</h1>
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
              <div className="form-check mx-2">
            <input
              type="checkbox"
              className="form-check-input"
              name="disponiblite"
              id="disponiblite"
              checked={disponibliteFilter}
              onChange={(event) => setDisponibliteFilter(event.target.checked)}
            />
            <label className="form-check-label" htmlFor="disponiblite">Available</label>
          </div>
              <i class="fa-solid fa-filter fa-xl mx-2" style={{cursor:"pointer", color: "black"}} 
                onMouseOver={(event) => event.target.style.color = "rgb(205, 164, 94)"}
                onMouseOut={(event) => event.target.style.color = "black"}
                onClick={()=>{setSearchTerm(""); setDisponibliteFilter(false)}}></i>              <div className="validate" />
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
            <th>Disponibility</th>
            <th>Phone Number</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {filteredLivreurs.map(livreur => (
            <tr key={livreur.id}>
              <td>{livreur.badge}</td>
              <td>{livreur.prenom}</td>
              <td>{livreur.nom}</td>
              <td>{livreur.salaire}</td>
              <td>{livreur.disponiblite ? <span style={{color: "green"}}>Available</span> : <span style={{color: "red"}}>Unavailable</span>}</td>
              <td>{livreur.numTel}</td>
              <td>
                <Link to={"edit/"+livreur.id}><button className="btn btn-primary mr-2">Edit</button></Link>
                <button onClick={() => handleDelete(livreur.id)} className="btn btn-danger">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default Livreurs;