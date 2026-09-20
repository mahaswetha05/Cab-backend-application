package com.example.cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cab.model.*;
import com.example.cab.service.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	RideService rs1;
	
	@PutMapping("/assign/{rideid}/{driverid}")
	public Ride driverAssign(@PathVariable int rideid,@PathVariable int driverid) {
		return rs1.assigndriver(rideid, driverid);
	}

}
