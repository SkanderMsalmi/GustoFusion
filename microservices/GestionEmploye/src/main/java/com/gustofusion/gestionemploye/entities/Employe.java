package com.gustofusion.gestionemploye.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Employe {
    private String nom;
    private String prenom;
    private int badge;
    private int salaire;

    public Employe(String nom, String prenom, int badge, int salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.badge = badge;
        this.salaire = salaire;
    }

    public Employe() {
    }
}
