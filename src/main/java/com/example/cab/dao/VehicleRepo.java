package com.example.cab.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cab.model.*;


public interface VehicleRepo extends JpaRepository<Vehicle,Integer>{

}
