package com.hnrq.parking.service;

import com.hnrq.parking.exception.CheckoutHasAlreadyException;
import com.hnrq.parking.exception.ParkingNotFoundException;
import com.hnrq.parking.model.entity.Parking;
import com.hnrq.parking.model.mapper.ParkingMapper;
import com.hnrq.parking.model.request.ParkingRequest;
import com.hnrq.parking.model.response.ParkingResponse;
import com.hnrq.parking.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {

//    private final ParkingRepository parkingRepository;
//
//    public ParkingService(ParkingRepository parkingRepository) {
//        this.parkingRepository = parkingRepository;
//    }

    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingMapper parkingMapper;
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    //@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<ParkingResponse> findAll() {
        List<Parking> parkingList = parkingRepository.findAll();
        return parkingMapper.toParkingResponseList(parkingList);
    }

    //@Transactional(readOnly = true)     //
    public ParkingResponse findById(String id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
        return parkingMapper.toParkingResponse(parking);
    }

    //@Transactional
    public ParkingResponse create(ParkingRequest request) {
        String uuid = getUUID();
        Parking parking = parkingMapper.toParking(request);
        parking.setId(uuid);
        parking.setEntryDate(LocalDateTime.now());
        Parking parkingSaved = parkingRepository.save(parking);
        return parkingMapper.toParkingResponse(parkingSaved);
    }

    //@Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    //@Transactional
    public ParkingResponse update(String id, ParkingRequest request) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
        parking.setBrand(request.getBrand());
        parking.setModel(request.getModel());
        parking.setColor(request.getColor());
        parking.setLicensePlate(request.getLicensePlate());
        Parking parkingSaved = parkingRepository.save(parking);
        return parkingMapper.toParkingResponse(parkingSaved);
    }

    //@Transactional
    public ParkingResponse checkOut(String id) {
        Parking parking = parkingRepository.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
        if(parking.getExitDate() == null) {
            parking.setExitDate(LocalDateTime.now());
            parking.setBill(CheckOutService.getBill(parking.getEntryDate(), parking.getExitDate()));
            parking = parkingRepository.save(parking);
        } else {
            throw new CheckoutHasAlreadyException();
        }
        return parkingMapper.toParkingResponse(parking);
    }

}