package com.example.cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cab.model.*;
import com.example.cab.service.*;


@RestController
@RequestMapping("/driver")

public class DriverController {
	
	@Autowired
	RideService rs2;
	
	@PutMapping("/start/{rideid}")
	public Ride rideStart(@PathVariable int rideid) {
		
		return rs2.startRide(rideid);
	}
	
	@PutMapping("/complete/{rideid}")
	public Ride rideComplete(@PathVariable int rideid) {
		
		return rs2.completeRide(rideid);
	}
	
	


}
