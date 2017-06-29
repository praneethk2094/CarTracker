package com.java.training.Service;

import com.java.training.Exceptions.BadRequest;
import com.java.training.entities.Alerts;
import com.java.training.entities.Vehicle;
import com.java.training.entities.VehicleReading;
import com.java.training.repository.AlertsRepository;
import com.java.training.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by prane on 6/28/2017.
 */
@Service
public class AlertsServiceImpl implements AlertsService {
    @Autowired
    private AlertsRepository alertsRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Transactional
    public void CreateAndSaveAlerts(VehicleReading vehicleReading) {
        Alerts alerts = new Alerts();
        Vehicle vehicle = vehicleRepository.findOne(vehicleReading.getVin());

        if (vehicleRepository.findOne(vehicleReading.getVin()) == null) {
            throw new BadRequest("No Vehicle of the Vin exists");
        }
        alerts.setVin(vehicleReading.getVin());
        alerts.setTimestamp(vehicleReading.getTimestamp());
        if (vehicleReading.getEngineRpm() > vehicle.getRedLineRpm()) {
            alerts.setEngineRpmAlert(Alerts.Alert.HIGH);
        }
        if (vehicleReading.getFuelVolume() < 0.1 * vehicle.getMaxFuelVolume()) {
            alerts.setFuelVolumeAlert(Alerts.Alert.MEDIUM);

        }
        if (vehicleReading.isEngineCoolantLow() || vehicleReading.isCheckEngineLightOn()) {
            alerts.setCheckEngineLightOnAlert(Alerts.Alert.LOW);
            alerts.setEngineCoolantAlert(Alerts.Alert.LOW);
        }
        List<Byte> list = Arrays.asList(vehicleReading.getTires().getFrontLeft(),
                vehicleReading.getTires().getFrontRight(), vehicleReading.getTires().getFrontRight(),
                vehicleReading.getTires().getRearRight());

        if (list.stream().filter(f -> (f < 32 || f > 36)).count() > 0) {
            alerts.setTirePressureAlert(Alerts.Alert.LOW);
        }

        alertsRepository.save(alerts);

    }

}
