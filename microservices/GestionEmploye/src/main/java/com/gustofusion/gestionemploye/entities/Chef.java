package com.gustofusion.gestionemploye.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Chef extends Employe implements Serializable  {
    @Id
    @GeneratedValue
    private int id;
    @OneToMany
    private List<SousChef> sousChefs;

    public Chef(String nom, String prenom, int badge, int salaire, int id, List<SousChef> sousChefs) {
        super(nom, prenom, badge, salaire);
        this.id = id;
        this.sousChefs = sousChefs;
    }

    public Chef() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SousChef> getSousChefs() {
        return sousChefs;
    }

    public void setSousChefs(List<SousChef> sousChefs) {
        this.sousChefs = sousChefs;
    }
}
