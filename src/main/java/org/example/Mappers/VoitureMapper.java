package org.example.Mappers;

import org.example.DTO.GarageDTO;
import org.example.DTO.VoitureDTO;
import org.example.entities.Garage;
import org.example.entities.Voiture;

import java.util.List;
import java.util.stream.Collectors;

public class VoitureMapper {

    public static VoitureDTO toDTO(Voiture voiture) {
        VoitureDTO dto = new VoitureDTO();
        dto.setMarque(voiture.getMarque());
        dto.setPuissance(voiture.getPuissance());
        dto.setGarageId(voiture.getGarage().getId());
        return dto;
    }

    public static Voiture toEntity(VoitureDTO dto, Garage garage) {
        Voiture voiture = new Voiture();
        voiture.setMarque(dto.getMarque());
        voiture.setPuissance(dto.getPuissance());
        voiture.setGarage(garage);
        return voiture;
    }

    public static List<VoitureDTO> toDTOList(List<Voiture> voitures) {
        return voitures.stream()
                .map(VoitureMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Voiture> toEntityList(List<VoitureDTO> voitureDTOS, GarageDTO garageDTO) {
        Garage garage = GarageMapper.toEntity(garageDTO);
        return voitureDTOS.stream()
                .map(voitureDTO -> toEntity(voitureDTO, garage))
                .collect(Collectors.toList());
    }
}
