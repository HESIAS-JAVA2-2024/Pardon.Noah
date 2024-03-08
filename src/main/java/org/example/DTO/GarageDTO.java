package org.example.DTO;

import org.example.entities.Voiture;

import java.util.List;

public class GarageDTO {

    private String name;
    private String address;
    private List<VoitureDTO> voitures;


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<VoitureDTO> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<VoitureDTO> voitures) {
        this.voitures = voitures;
    }
}
