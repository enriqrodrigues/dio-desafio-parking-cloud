package com.hnrq.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException {
//Usar RuntimeException não precisa de try/catch

    public ParkingNotFoundException(String id) {
        super("Parking not found with Id: " + id);
    }
}