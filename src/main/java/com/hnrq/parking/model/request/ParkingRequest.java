package com.hnrq.parking.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingRequest {

    private String licensePlate;
    private String brand;
    private String model;
    private String color;

}