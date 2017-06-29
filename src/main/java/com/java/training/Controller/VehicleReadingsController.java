package com.java.training.Controller;

import com.java.training.Service.VehicleReadingsService;
import com.java.training.entities.VehicleReading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by prane on 6/27/2017.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/readings")
public class VehicleReadingsController {
    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private VehicleReadingsService vehicleReadingsService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    VehicleReading AddVehicleReadings(@RequestBody VehicleReading vehicleReadings) {
        return vehicleReadingsService.saveReadings(vehicleReadings);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/find/{Vehicleid}")
    public @ResponseBody
    List<VehicleReading> findVehicleReadingByID(@PathVariable String Vehicleid) {
        return vehicleReadingsService.findOneVehicleReadings(Vehicleid);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public void Delete(@RequestBody VehicleReading vehicleReading) {
        vehicleReadingsService.deleteVehicleReading(vehicleReading);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vehicleID}")
    public void Delete(@PathVariable String VehicleId) {
        vehicleReadingsService.deleteAllVehicleReading(VehicleId);
    }


    /*@RequestMapping(method = RequestMethod.GET, value = "/find" )
    public @ResponseBody List<VehicleReading> findAllVehicleReadings(){
        return vehicleReadingsService.findAllReadings();
    }*/
}
