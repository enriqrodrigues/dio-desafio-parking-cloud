package com.hnrq.parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CheckoutHasAlreadyException extends RuntimeException{

    public CheckoutHasAlreadyException() {
        super("Vehicle has already been checked out.");
    }

}
