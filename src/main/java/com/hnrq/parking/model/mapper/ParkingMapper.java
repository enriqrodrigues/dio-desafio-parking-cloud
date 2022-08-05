package com.hnrq.parking.model.mapper;

import com.hnrq.parking.model.entity.Parking;
import com.hnrq.parking.model.request.ParkingRequest;
import com.hnrq.parking.model.response.ParkingResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    public Parking toParking(ParkingRequest request) {
        Parking parking = new Parking();
        parking.setLicensePlate(request.getLicensePlate());
        parking.setBrand(request.getBrand());
        parking.setModel(request.getModel());
        parking.setColor(request.getColor());
        return parking;
    }

    public ParkingResponse toParkingResponse(Parking parking) {
        ParkingResponse response = new ParkingResponse();
        response.setId(parking.getId());
        response.setLicensePlate(parking.getLicensePlate());
        response.setBrand(parking.getBrand());
        response.setModel(parking.getModel());
        response.setColor(parking.getColor());
        response.setEntryDate(parking.getEntryDate());
        response.setExitDate(parking.getExitDate());
        response.setBill(parking.getBill());
        return response;
    }

    public List<ParkingResponse> toParkingResponseList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingResponse).collect(Collectors.toList());
    }

}