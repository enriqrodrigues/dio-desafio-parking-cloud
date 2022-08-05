package com.hnrq.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
//import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping
@ApiIgnore
//@ApiIgnore      //Oculta o endpoint no swagger
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello. Welcome to my application!";
    }

}
