package org.example.Mappers;

import org.example.DTO.GarageDTO;
import org.example.entities.Garage;

import java.util.List;
import java.util.stream.Collectors;

public class GarageMapper {

    public static GarageDTO toDTO(Garage garage) {
        GarageDTO dto = new GarageDTO();
        dto.setName(garage.getName());
        dto.setAddress(garage.getAddress());
        dto.setVoitures(garage.getVoitures().stream()
                .map(VoitureMapper::toDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    public static Garage toEntity(GarageDTO dto) {
        Garage garage = new Garage();
        garage.setName(dto.getName());
        garage.setAddress(dto.getAddress());
        if (dto.getVoitures() != null){
            garage.setVoitures(VoitureMapper.toEntityList(dto.getVoitures(), dto));
        }
        return garage;
    }

    public static List<GarageDTO> toDTOList(List<Garage> garages) {
        return garages.stream()
                .map(GarageMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static List<Garage> toEntityList(List<GarageDTO> garageDTOS) {
        return garageDTOS.stream()
                .map(GarageMapper::toEntity)
                .collect(Collectors.toList());
    }

}
