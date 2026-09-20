package com.example.cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cab.model.*;
import com.example.cab.service.*;
import com.example.cab.dto.*;

@RestController
@RequestMapping("/passenger")

public class UserController {
	
	@Autowired
	RideService rs;
	
	//RideRequest(dto)-pickup,drop loc assign,if not dto-string pickup,string drop instead of RideRequest request
	@PostMapping("/ride/{passengerid}")
	public Ride bookRide(@PathVariable int passengerid,@RequestBody RideRequest request){
		
		return rs.requestRide(passengerid, request);
		
		
	}

}
