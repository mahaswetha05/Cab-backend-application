package com.example.cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.cab.model.Vehicle;
import com.example.cab.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vs;

    @PostMapping("/add/{driverId}")
    public Vehicle addVehicle(
            @PathVariable int driverId,
            @RequestBody Vehicle vehicle) {

        return vs.addVehicle(driverId, vehicle);
    }
}