package com.java.training.Service;

import com.java.training.entities.Alerts;
import com.java.training.entities.VehicleReading;

/**
 * Created by praneeth on 6/28/2017.
 */


public interface AlertsService {
    void CreateAndSaveAlerts(VehicleReading vehicleReading);
}
