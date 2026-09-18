package com.example.cab.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cab.model.*;

public interface RideRepo extends JpaRepository<Ride,Integer>{

	List<Ride> findByPassengerId(int passengerid);
	List<Ride> findByDriverId(int driverid);

	
}
