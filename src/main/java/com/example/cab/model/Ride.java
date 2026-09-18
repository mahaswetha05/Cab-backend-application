package com.example.cab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity

public class Ride {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	int id;
	String pickupLocation;
	String dropLocation;
	
	@ManyToOne
	User passenger;
	
	@ManyToOne
	User driver;
	
	int fare;
	
	@Enumerated(EnumType.STRING)
	RideStatus status;

	public Ride() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ride(String pickupLocation, String dropLocation, User passenger, User driver, int fare, RideStatus status) {
		super();
		this.pickupLocation = pickupLocation;
		this.dropLocation = dropLocation;
		this.passenger = passenger;
		this.driver = driver;
		this.fare = fare;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}

	public User getDriver() {
		return driver;
	}

	public void setDriver(User driver) {
		this.driver = driver;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}
	
	

}
