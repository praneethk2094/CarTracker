package com.java.training.Service;


import com.java.training.entities.VehicleReading;

import java.util.List;

public interface VehicleReadingsService {
    VehicleReading saveReadings(VehicleReading vehicleReadingList);

    /*List<VehicleReading> findAllReadings();*/
    List<VehicleReading> findOneVehicleReadings(String vin);

    void deleteVehicleReading(VehicleReading vehicleReading);

    void deleteAllVehicleReading(String VehicleID);
}
