package org.example.Controllers;

import org.example.DTO.GarageDTO;
import org.example.Mappers.GarageMapper;
import org.example.Services.GarageService;
import org.example.Services.VoitureService;
import org.example.entities.Garage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
public class GarageController {

    private final GarageService garageService;

    @Autowired
    GarageController(GarageService garageService) {
        this.garageService = garageService;
    }


    @GetMapping("/")
    public ResponseEntity all() {
        try {
            List<Garage> garages = garageService.getAllGarages();
            List<GarageDTO> garageDTOS = GarageMapper.toDTOList(garages);
            return ResponseEntity.ok(garageDTOS);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getGarageById(@PathVariable("id") int id) {
        try {
            Garage garage = garageService.getGarageById(id);
            GarageDTO garageDTO = GarageMapper.toDTO(garage);
            return ResponseEntity.ok(garageDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/addGarage")
    public ResponseEntity addGarage(@RequestBody GarageDTO garageDTO) {
        try {
            Garage garage = GarageMapper.toEntity(garageDTO);
            garageService.addGarage(garage);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping("{garageId}/addVoiture/{voitureId}")
    public ResponseEntity addVoitureToGarage(@PathVariable("garageId") int garageId, @PathVariable("voitureId") int voitureId) {
        try {
            garageService.addVoitureToGarage(garageId, voitureId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{garageId}/removeVoiture/{voitureId}")
    public ResponseEntity removeVoitureFromGarage(@PathVariable("garageId") int garageId, @PathVariable("voitureId") int voitureId) {
        try {
            garageService.removeVoitureFromGarage(garageId, voitureId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
