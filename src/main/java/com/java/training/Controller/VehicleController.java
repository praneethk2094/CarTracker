package com.java.training.Controller;

import com.java.training.Aspect.BoundaryLogger;
import com.java.training.Service.VehicleService;
import com.java.training.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by prane on 6/26/2017.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/vehicles")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @BoundaryLogger
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    List<Vehicle> AddVehicles(@RequestBody List<Vehicle> vehicles) {
        return vehicleService.saveVehicles(vehicles);
    }

    @BoundaryLogger
    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public @ResponseBody
    List<Vehicle> findVehicles() {
        return vehicleService.findAllVehicles();
    }

    @BoundaryLogger
    @RequestMapping(method = RequestMethod.GET, value = "/find/{VehicleId}")
    public @ResponseBody
    Vehicle findVehicle(@PathVariable("VehicleId") String VehicleId) {
        return vehicleService.findOneVehicle(VehicleId);
    }

    @BoundaryLogger
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public void Delete(@RequestBody Vehicle vehicle) {
        vehicleService.deleteVehicle(vehicle);
    }

    @BoundaryLogger
    @RequestMapping(method = RequestMethod.DELETE, value = "/{vehicleId}")
    public void Delete(@PathVariable("vehicleId") String VehicleId) {
        vehicleService.deleteVehicleById(VehicleId);
    }
}
