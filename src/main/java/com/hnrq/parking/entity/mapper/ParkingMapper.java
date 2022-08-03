package com.hnrq.parking.entity.mapper;

import com.hnrq.parking.entity.Parking;
import com.hnrq.parking.entity.dto.ParkingCreateDTO;
import com.hnrq.parking.entity.dto.ParkingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking) {
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
        //O método map recebe um objeto fonte e um objeto de destino: map(source, destiny).
        //No caso, ele recebe uma entidade e retorna um DTO. O oposto também pode ser feito.
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public Parking toParking(ParkingDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }

    public Parking toParkingCreate(ParkingCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }
}