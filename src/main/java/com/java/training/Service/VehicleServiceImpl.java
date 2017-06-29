package com.java.training.Service;

import com.java.training.Exceptions.NotFoundException;
import com.java.training.Exceptions.Sucess;
import com.java.training.entities.Vehicle;
import com.java.training.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by prane on 6/27/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private VehicleRepository vehicleRepository;

   /* public Vehicle save(Vehicle vehicle) {
     return   vehicleRepository.save(vehicle);
    }*/

    @Transactional
    public List<Vehicle> saveVehicles(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            if (vehicleRepository.findAll().contains(v)) {
                vehicles.remove(v);
            }
        }
        return vehicleRepository.save(vehicles);
    }

    @Transactional
    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();

    }

    @Transactional
    public Vehicle findOneVehicle(String vin) {
        Vehicle vehicle = vehicleRepository.findOne(vin);
        if (vehicle == null) {
            throw new NotFoundException("No Vehicle with with the specified details exists!!");
        }
        return vehicle;
    }

    @Transactional
    public void deleteVehicle(Vehicle vehicle) {
        if (vehicleRepository.findOne(vehicle.getVin()) == null) {
            throw new NotFoundException("No Vehicle with the specified details exists!!");
        } else {
            vehicleRepository.delete(vehicle);
            throw new Sucess("Vehicle deleted successfully!!");
        }
    }

    @Transactional
    public void deleteVehicleById(String vehicleId) {
        if (vehicleRepository.findOne(vehicleId) == null) {
            throw new NotFoundException("No Vehicle with the specified details exists!!");
        } else {
            vehicleRepository.delete(vehicleId);
            throw new Sucess("Vehicle deleted successfully!!");
        }
    }
}
