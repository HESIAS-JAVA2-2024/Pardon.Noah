package org.example.Services;

//import org.example.DAO.UserDao;
import org.example.Repoitory.GarageRepository;
import org.example.Repoitory.VoitureRepository;
import org.example.entities.Garage;
import org.example.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    private final GarageRepository garageRepository;
    private final VoitureRepository voitureRepository;

    @Autowired
    public GarageService(GarageRepository garageRepository, VoitureRepository voitureRepository) {
        this.garageRepository = garageRepository;
        this.voitureRepository = voitureRepository;
    }


    public void addGarage(Garage garage) {
        garageRepository.save(garage);
    }

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public Garage getGarageById(int id) {
        return garageRepository.findById(id).orElse(null);
    }

    public void addVoitureToGarage(int garageId, int voitureId) {
        Garage garage = garageRepository.findById(garageId).orElse(null);
        Voiture voiture = voitureRepository.findById(voitureId).orElse(null);
        voiture.setGarage(garage);
        garage.getVoitures().add(voiture);
        System.out.println("Voiture " + voiture.getMarque() + " added to garage " + garage.getName());
        garageRepository.save(garage);
    }

    public void removeVoitureFromGarage(int garageId, int voitureId) {
        Garage garage = garageRepository.findById(garageId).orElse(null);
        Voiture voiture = voitureRepository.findById(voitureId).orElse(null);
        voiture.setGarage(null);
        garage.getVoitures().remove(voiture);
        System.out.println("Voiture " + voiture.getMarque() + " removed from garage " + garage.getName());
        garageRepository.save(garage);
    }
}
