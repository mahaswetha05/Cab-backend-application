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
	
	//user 
	public Ride requestRide(int passengerid,RideRequest request) {
		Ride r=new Ride();
		r.setPassenger(ur2.findById(passengerid).get());
		r.setPickupLocation(request.getPickup());
		r.setDropLocation(request.getDrop());
		r.setStatus(RideStatus.REQUESTED);
		r.setFare(1000);
		return rr1.save(r);
		
	}
	//admin assigning driver
	public Ride assigndriver(int rideid,int driverid) {
		Ride r=rr1.findById(rideid).get();
		User driver=ur2.findById(driverid).get();
		r.setDriver(driver);
		r.setStatus(RideStatus.ACCEPTED);
		return rr1.save(r);
		
	}
	
	// driver see the ride,otp(rideid) start ride
	
	public Ride startRide(int rideid) {
		
		Ride r=rr1.findById(rideid).get();
		r.setStatus(RideStatus.STARTED);
		return rr1.save(r);
	}
	//driver update status
    public Ride completeRide(int rideid) {
		
		Ride r=rr1.findById(rideid).get();
		r.setStatus(RideStatus.COMPLETED);
		return rr1.save(r);
	}
    
    public Ride cancellRide(int rideid) {
		
		Ride r=rr1.findById(rideid).get();
		r.setStatus(RideStatus.CANCELLED);
		return rr1.save(r);
	}
    
    
	

	

	
	
}
