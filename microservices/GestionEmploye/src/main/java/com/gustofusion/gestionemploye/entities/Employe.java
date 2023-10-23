package com.gustofusion.gestionemploye.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
}
