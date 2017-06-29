package com.java.training.Service;


import com.java.training.entities.Vehicle;

import java.util.List;


public interface VehicleService {

    // Vehicle save(Vehicle vehicle);
    List<Vehicle> saveVehicles(List<Vehicle> vehicleList);

    List<Vehicle> findAllVehicles();

    Vehicle findOneVehicle(String vin);

    void deleteVehicle(Vehicle vehicle);

    void deleteVehicleById(String vehicleId);
}
