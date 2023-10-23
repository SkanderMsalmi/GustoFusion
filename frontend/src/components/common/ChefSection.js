import axios from "axios";
import React, { useEffect, useState } from "react";

function ChefSection() {
  const [chefs, setChefs] = useState([]);

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

  return (
    <div>
      <div>
        <section id="chefs" className="chefs">
          <div className="container" data-aos="fade-up">
            <div className="section-title">
              <h2>Chefs</h2>
              <p>Our Professional Chefs</p>
            </div>
            {chefs.length > 0 ? (
              <div className="row">
                {chefs.slice(0, 3).map((chef, index) => (
                  <div className="col-lg-4 col-md-6" key={chef.id}>
                    <div
                      className="member"
                      data-aos="zoom-in"
                      data-aos-delay={100 * index}
                    >
                      <img
                        src={`assets/img/chefs/chefs-${index + 1}.jpg`}
                        className="img-fluid"
                        alt={`chef-${chef.id}`}
                      />
                      <div className="member-info">
                        <div className="member-info-content">
                          <h4>
                            {chef.nom
                              .split(" ")
                              .map(
                                (word) =>
                                  word.charAt(0).toUpperCase() + word.slice(1)
                              )
                              .join(" ") +
                              " " +
                              chef.prenom
                                .split(" ")
                                .map(
                                  (word) =>
                                    word.charAt(0).toUpperCase() + word.slice(1)
                                )
                                .join(" ")}
                          </h4>
                          <span>
                            {chef.specialite
                              .split(" ")
                              .map(
                                (word) =>
                                  word.charAt(0).toUpperCase() + word.slice(1)
                              )
                              .join(" ")}
                          </span>
                        </div>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            ) : (
              <div className="row justify-content-center">
                <h3>Coming Soon...</h3>
              </div>
            )}
          </div>
        </section>
      </div>
    </div>
  );
}

export default ChefSection;
