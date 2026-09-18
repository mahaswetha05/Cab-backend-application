package com.example.cab.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cab.dao.*;
import com.example.cab.model.*;

@Service

public class VehicleService {
	
	@Autowired
	VehicleRepo vr1;
	
	public Vehicle addVehicle(Vehicle v) {
		
		return vr1.save(v);
	}

}
