import React, { useState, useEffect } from "react";
import axios from "axios";

const CreateSousChef = () => {
  const [badge, setBadge] = useState("");
  const [prenom, setPrenom] = useState("");
  const [nom, setNom] = useState("");
  const [salaire, setSalaire] = useState("");
  const [typeService, setTypeService] = useState("");
  const [chefId, setChefId] = useState("");
  const [chefs, setChefs] = useState([]);
  const [errors, setErrors] = useState({});

  useEffect(() => {
    axios
      .get("http://localhost:8088/api/employe/api/chef")
      .then((response) => {
        setChefs(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    let errors = {};
    if (!badge) {
      errors.badge = "Badge # is required";
    }
    if (!prenom) {
      errors.prenom = "First Name is required";
    }
    if (!nom) {
      errors.nom = "Last Name is required";
    }
    if (!salaire) {
      errors.salaire = "Salary is required";
    }
    if (!typeService) {
      errors.typeService = "Type of Service is required";
    }
    if (!chefId) {
      errors.chefId = "Chef ID is required";
    }

    if (Object.keys(errors).length === 0) {
      const chef = chefs.find((chef) => chef.id === Number(chefId));
      console.log(chefs);
      console.log(chef);
      const sousChef = {
        badge: Number(badge),
        prenom: prenom,
        nom: nom,
        salaire: Number(salaire),
        typeService: typeService,
        chef: chef,
      };
      axios
        .post("http://localhost:8088/api/employe/api/sous-chef", sousChef)
        .then((response) => {
          console.log(response);
          window.location.href = "/admin/employees/sousChefs";
        })
        .catch((error) => {
          console.log(error.response.data);
          setErrors(error.response.data);
        });
    } else {
      setErrors(errors);
    }
  };

  return (
    <div className="container" style={{ color: "black" }}>
      <h1>Create Sous Chef</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="badge">Badge #:</label>
          <input
            type="text"
            className={`form-control ${errors.badge ? "is-invalid" : ""}`}
            id="badge"
            value={badge}
            onChange={(event) => setBadge(event.target.value)}
          />
          {errors.badge && (
            <div className="invalid-feedback">{errors.badge}</div>
          )}
        </div>
        <div className="form-group">
          <label htmlFor="prenom">First Name:</label>
          <input
            type="text"
            className={`form-control ${errors.prenom ? "is-invalid" : ""}`}
            id="prenom"
            value={prenom}
            onChange={(event) => setPrenom(event.target.value)}
          />
          {errors.prenom && (
            <div className="invalid-feedback">{errors.prenom}</div>
          )}
        </div>
        <div className="form-group">
          <label htmlFor="nom">Last Name:</label>
          <input
            type="text"
            className={`form-control ${errors.nom ? "is-invalid" : ""}`}
            id="nom"
            value={nom}
            onChange={(event) => setNom(event.target.value)}
          />
          {errors.nom && <div className="invalid-feedback">{errors.nom}</div>}
        </div>
        <div className="form-group">
          <label htmlFor="salaire">Salary:</label>
          <input
            type="text"
            className={`form-control ${errors.salaire ? "is-invalid" : ""}`}
            id="salaire"
            value={salaire}
            onChange={(event) => setSalaire(event.target.value)}
          />
          {errors.salaire && (
            <div className="invalid-feedback">{errors.salaire}</div>
          )}
        </div>
        <div className="form-group">
          <label htmlFor="typeService">Type of Service:</label>
          <select
            className={`form-control ${errors.typeService ? "is-invalid" : ""}`}
            id="typeService"
            value={typeService}
            onChange={(event) => setTypeService(event.target.value)}
          >
            <option value="">Select a Service Type</option>
            <option value="JOUR">Day Service</option>
            <option value="NUIT">Night Service</option>
          </select>
          {errors.typeService && (
            <div className="invalid-feedback">{errors.typeService}</div>
          )}
        </div>
        <div className="form-group">
          <label htmlFor="chefId">Chef:</label>
          <select
            className={`form-control ${errors.chefId ? "is-invalid" : ""}`}
            id="chefId"
            value={chefId}
            onChange={(event) => setChefId(event.target.value)}
          >
            <option value="">Select a Chef</option>
            {chefs.map((chef) => (
              <option key={chef.id} value={chef.id}>
                {chef.nom} {chef.prenom}
              </option>
            ))}
          </select>
          {errors.chefId && (
            <div className="invalid-feedback">{errors.chefId}</div>
          )}
        </div>

        <button type="submit" className="btn btn-primary">
          Create
        </button>
      </form>
    </div>
  );
};

export default CreateSousChef;
