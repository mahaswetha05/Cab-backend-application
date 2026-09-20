package com.example.cab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cab.model.*;
import com.example.cab.service.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/register")
	public User saveReg(@RequestBody User u) {
		
		return us.regUser(u);
	}
	

}
