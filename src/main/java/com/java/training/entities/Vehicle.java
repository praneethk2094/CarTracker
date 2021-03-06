package com.java.training.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Date;

@Data
@Entity
public class Vehicle {

    @Id
    private String vin;
    private String make;
    private String model;
    private short year;
    private short redLineRpm;
    private float maxFuelVolume;
    private Date lastServiceDate;

    public Vehicle() {
    }

    public Vehicle(String vin, String make, String model) {
        this.vin = vin;
        this.make = make;
        this.model = model;
    }
    /* @OneToMany(mappedBy="vin",cascade= CascadeType.ALL )
    @JsonIgnore
    private List<VehicleReading> vehicleReadings;*/

  /*  @OneToMany(mappedBy="Vehicle",cascade= CascadeType.ALL )
    @JsonIgnore
    private List<Alerts> Alerts;*/
}
