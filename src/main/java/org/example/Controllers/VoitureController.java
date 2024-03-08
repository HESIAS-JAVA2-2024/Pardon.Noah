package org.example.Controllers;

import org.example.DTO.GarageDTO;
import org.example.DTO.VoitureDTO;
import org.example.Mappers.GarageMapper;
import org.example.Mappers.VoitureMapper;
import org.example.Services.GarageService;
import org.example.Services.VoitureService;
import org.example.entities.Garage;
import org.example.entities.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {

    private final VoitureService voitureService;
    private final GarageService garageService;

    @Autowired
    VoitureController(VoitureService voitureService, GarageService garageService) {
        this.voitureService = voitureService;
        this.garageService = garageService;
    }


    @GetMapping("/")
    public ResponseEntity all() {
        try {
            List<Voiture> voitures = voitureService.getAllVoitures();
            List<VoitureDTO> voitureDTOS = VoitureMapper.toDTOList(voitures);
            return ResponseEntity.ok(voitureDTOS);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getVoitureById(@PathVariable("id") int id) {
        try {
            Voiture voiture = voitureService.getVoitureById(id);
            VoitureDTO voitureDTO = VoitureMapper.toDTO(voiture);
            return ResponseEntity.ok(voitureDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/addVoiture")
    public ResponseEntity addVoiture(@RequestBody VoitureDTO voitureDTO) {
        try {
            Garage garage = garageService.getGarageById(voitureDTO.getGarageId());
            Voiture voiture = VoitureMapper.toEntity(voitureDTO, garage);
            voitureService.addVoiture(voiture);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
