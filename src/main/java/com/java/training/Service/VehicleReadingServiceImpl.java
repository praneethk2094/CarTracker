package com.java.training.Service;

import com.java.training.Exceptions.BadRequest;
import com.java.training.Exceptions.NotFoundException;
import com.java.training.Exceptions.Sucess;
import com.java.training.entities.VehicleReading;
import com.java.training.repository.VehicleReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by praneeth on 6/27/2017.
 */
@Service
public class VehicleReadingServiceImpl implements VehicleReadingsService {

    private final VehicleReadingRepository vehicleReadingRepository;
    private final AlertsService alertsService;

    @Autowired
    public VehicleReadingServiceImpl(VehicleReadingRepository vehicleReadingRepository, AlertsService alertsService) {
        this.vehicleReadingRepository = vehicleReadingRepository;
        this.alertsService = alertsService;
    }

    @Transactional
    public VehicleReading saveReadings(VehicleReading vehicleReading) {
        if (vehicleReading.getVin() == null) {
            throw new BadRequest("Input value missing fields");
        }
        alertsService.CreateAndSaveAlerts(vehicleReading);
        return vehicleReadingRepository.save(vehicleReading);

    }

    /*  public List<VehicleReading> findAllReadings() {
          return vehicleReadingRepository.findAll();
      }*/
    @Transactional
    public List<VehicleReading> findOneVehicleReadings(String vin) {

        List<VehicleReading> vehicleReadings = vehicleReadingRepository.findAllByVin(vin);
        if (vehicleReadings == null) {
            throw new NotFoundException("No readings for specified input");
        } else return vehicleReadings;
    }

    @Transactional
    public void deleteVehicleReading(VehicleReading vehicleReading) {
        if (vehicleReadingRepository.findOne(vehicleReading.getVehicleReadingId()) == null) {
            throw new NotFoundException("No readings with the specified details exists!!");
        } else {
            vehicleReadingRepository.delete(vehicleReading);
            throw new Sucess("Reading deleted successfully!!");
        }
    }

    @Transactional
    public void deleteAllVehicleReading(String vin) {
        if (vehicleReadingRepository.findAllByVin(vin) == null) {
            throw new NotFoundException("No readings for the specified details exists!!");
        } else {
            vehicleReadingRepository.deleteAllByVin(vin);
            throw new Sucess("Readings deleted successfully!!");
        }
    }
}
