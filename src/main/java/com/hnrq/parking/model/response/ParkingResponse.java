package com.hnrq.parking.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//A anotação acima faz que apenas objetos não nulos sejam incluídos no resultado.
public class ParkingResponse {

    private String id;
    private String licensePlate;
    private String brand;
    private String model;
    private String color;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime entryDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime exitDate;
    private Double bill;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }
}