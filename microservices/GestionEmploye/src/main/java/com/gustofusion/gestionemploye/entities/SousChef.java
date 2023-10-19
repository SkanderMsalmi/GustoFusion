package com.gustofusion.gestionemploye.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SousChef extends Employe implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private TypeService typeService;
    @ManyToOne
    private Chef chef;

    public SousChef() {
    }

    public SousChef(String nom,String prenom,int badge,int salaire,int id,TypeService typeService, Chef chef) {
        super(nom,prenom,badge,salaire);
        this.id = id;
        this.typeService = typeService;
        this.chef = chef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }
}
