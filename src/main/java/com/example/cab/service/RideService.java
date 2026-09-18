package com.example.cab.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cab.dao.*;
import com.example.cab.model.*;
import com.example.cab.dto.*;


@Service

public class RideService {

	@Autowired
	RideRepo rr1;
	
//	user has many to one relationship with vehicle,so object for user created
	
	@Autowired
	UserRepo ur2;
	
	
	public Ride requestRide(int passengerid,RideRequest request) {
		Ride r=new Ride();
		r.setPassenger(ur2.findById(passengerid).get());
		r.setPickupLocation(request.getPickup());
		r.setDropLocation(request.getDrop());
		r.setStatus(RideStatus.REQUESTED);
		r.setFare(1000);
		return rr1.save(r);
		
	}
}
