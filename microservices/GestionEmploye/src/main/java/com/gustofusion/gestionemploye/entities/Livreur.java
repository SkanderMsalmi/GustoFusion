package com.gustofusion.gestionemploye.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Livreur extends Employe implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private boolean disponiblite;
    private int numTel;

    public Livreur(String nom, String prenom, int badge, int salaire,int id, boolean disponiblite, int numTel) {
        super(nom, prenom, badge, salaire);
        this.id = id;
        this.disponiblite = disponiblite;
        this.numTel = numTel;
    }

    public Livreur() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisponiblite() {
        return disponiblite;
    }

    public void setDisponiblite(boolean disponiblite) {
        this.disponiblite = disponiblite;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }
}
