package com.example.cab.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cab.dao.*;
import com.example.cab.model.*;

@Service

public class VehicleService {
	
	@Autowired
	VehicleRepo vr1;
	
	@Autowired
	UserRepo ur3;
	
	public Vehicle addVehicle(int driverId, Vehicle vehicle) {

	    User driver = ur3.findById(driverId)
	            .orElseThrow(() -> new RuntimeException("Driver not found"));

	    vehicle.setDriver(driver);

	    return vr1.save(vehicle);
	}

}
