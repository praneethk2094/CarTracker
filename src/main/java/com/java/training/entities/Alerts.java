package com.java.training.entities;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;


@Data
@Entity
public class Alerts {
    public enum Alert {
        HIGH, MEDIUM, LOW
    }

    @Id
    private String AlertsID;
    private String vin;
    private Timestamp timestamp;
    private Alert engineRpmAlert;
    private Alert fuelVolumeAlert;
    private Alert tirePressureAlert;
    private Alert engineCoolantAlert;
    private Alert checkEngineLightOnAlert;

    public Alerts() {
        AlertsID = UUID.randomUUID().toString();
    }
}
