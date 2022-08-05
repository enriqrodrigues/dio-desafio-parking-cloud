package com.hnrq.parking.controller;

import com.hnrq.parking.model.request.ParkingRequest;
import com.hnrq.parking.model.response.ParkingResponse;
import com.hnrq.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
//@Api(tags = "Parking Controller")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping
    //@ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingResponse>> findAll() {
        List<ParkingResponse> responseList = parkingService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingResponse> findById(@PathVariable String id) {
        ParkingResponse response = parkingService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping
    public ResponseEntity<ParkingResponse> checkIn(@RequestBody ParkingRequest request) {
        ParkingResponse response = parkingService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ParkingResponse> checkOut(@PathVariable String id) {
        ParkingResponse response = parkingService.checkOut(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingResponse> update(@PathVariable String id,
                                                  @RequestBody ParkingRequest request) {
        ParkingResponse response = parkingService.update(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
