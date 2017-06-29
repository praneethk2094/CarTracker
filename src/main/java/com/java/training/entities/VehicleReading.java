package com.java.training.entities;

import lombok.Data;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Data
@Entity
public class VehicleReading {
    @Id
    private String VehicleReadingId;
    private String vin;
    private double longitude;
    private double latitude;
    private Timestamp timestamp;
    private double fuelVolume;
    private float speed;
    private short engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private short engineRpm;

    @Embedded
    private Tires tires;

    /*@ManyToOne
    @JoinColumn(name = "VehicleID")
    private Vehicle vehicle;*/


    public VehicleReading() {
        VehicleReadingId = UUID.randomUUID().toString();
    }


}
