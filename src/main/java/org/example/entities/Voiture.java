package org.example.entities;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //make not null
    private String marque;

    private int puissance;

    @ManyToOne
    @JoinColumn(name="garage_id", nullable=true)
    private Garage garage;


    public Voiture(String marque, int puissance) {
        this.marque = marque;
        this.puissance = puissance;
    }

    public Voiture() {
    }

    public String getMarque() {
        return marque;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }
}
