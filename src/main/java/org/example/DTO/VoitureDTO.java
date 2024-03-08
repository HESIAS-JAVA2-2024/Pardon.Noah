package org.example.DTO;

import jakarta.annotation.Nonnull;
import org.antlr.v4.runtime.misc.NotNull;

public class VoitureDTO {

    private String marque;
    private int puissance;

    private int garageId;

    public VoitureDTO() {
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

    public int getGarageId() {
        return garageId;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }


}
