package com.example.cab.dto;

//lombok dependency can add from browser-copy and paste here,to use @Data(getterand setter)

public class RideRequest {
	
	String pickup;
	String drop;
//	these needed for all passenger, driver.to use and create again and again so we are storing here
	
	
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDrop() {
		return drop;
	}
	public void setDrop(String drop) {
		this.drop = drop;
	}
	
	

}
