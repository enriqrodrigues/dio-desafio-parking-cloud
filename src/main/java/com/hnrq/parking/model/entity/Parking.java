package com.hnrq.parking.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_parking")
public class Parking {

    @Id
    private String id;
    @Column
    private String licensePlate;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String color;
    @Column
    private LocalDateTime entryDate;
    @Column
    private LocalDateTime exitDate;
    @Column
    private Double bill;

    public Parking(String id, String licensePlate, String brand, String model, String color) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

}