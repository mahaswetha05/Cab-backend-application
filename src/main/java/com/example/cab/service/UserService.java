package com.example.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cab.dao.*;
import com.example.cab.model.*;

@Service
public class UserService {
	
	@Autowired
	UserRepo ur1;
	
	public User regUser(User u) {
		return ur1.save(u);
	}

}
