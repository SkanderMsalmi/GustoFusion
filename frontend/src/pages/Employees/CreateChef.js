import React, { useState } from 'react';
import axios from 'axios';

const CreateChef = () => {
    const [badge, setBadge] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [salary, setSalary] = useState('');
    const [specialty, setSpecialty] = useState('');
    const [errors, setErrors] = useState({});

    const handleSubmit = (event) => {
        event.preventDefault();
        let errors = {};
        if (!badge) {
            errors.badge = 'Badge # is required';
        }
        if (!firstName) {
            errors.firstName = 'First Name is required';
        }
        if (!lastName) {
            errors.lastName = 'Last Name is required';
        }
        if (!salary) {
            errors.salary = 'Salary is required';
        }
        if (!specialty) {
            errors.specialty = 'Specialty is required';
        }
       
        if (Object.keys(errors).length === 0) {
            const chef = { badge:Number(badge), prenom:firstName, nom:lastName, salaire:Number(salary), specialite:specialty };
            axios.post('http://localhost:8083/api/chef', chef)
              .then(response => {
                console.log(response);
                window.location.href = '/admin/employees/chefs'; 

              })
              .catch(error => {
                console.log(error.response.data);
                setErrors(error.response.data);
              });
        } else {
            setErrors(errors);
        }
    };

    return (
        <div className="container" style={{color: "black"}}>
            <h1>Create Chef</h1>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label htmlFor="badge">Badge #:</label>
                    <input
                        type="text"
                        className={`form-control ${errors.badge ? 'is-invalid' : ''}`}
                        id="badge"
                        value={badge}
                        onChange={(event) => setBadge(event.target.value)}
                    />
                    {errors.badge && <div className="invalid-feedback">{errors.badge}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="firstName">First Name:</label>
                    <input
                        type="text"
                        className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                        id="firstName"
                        value={firstName}
                        onChange={(event) => setFirstName(event.target.value)}
                    />
                    {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="lastName">Last Name:</label>
                    <input
                        type="text"
                        className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                        id="lastName"
                        value={lastName}
                        onChange={(event) => setLastName(event.target.value)}
                    />
                    {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="salary">Salary:</label>
                    <input
                        type="text"
                        className={`form-control ${errors.salary ? 'is-invalid' : ''}`}
                        id="salary"
                        value={salary}
                        onChange={(event) => setSalary(event.target.value)}
                    />
                    {errors.salary && <div className="invalid-feedback">{errors.salary}</div>}
                </div>
                <div className="form-group">
                    <label htmlFor="specialty">Specialty:</label>
                    <input
                        type="text"
                        className={`form-control ${errors.specialty ? 'is-invalid' : ''}`}
                        id="specialty"
                        value={specialty}
                        onChange={(event) => setSpecialty(event.target.value)}
                    />
                    {errors.specialty && <div className="invalid-feedback">{errors.specialty}</div>}
                </div>
            
                <button type="submit" className="btn btn-primary">Create</button>
            </form>
        </div>
    );
};

export default CreateChef;