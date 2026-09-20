package com.example.cab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.cab.dao.*;
import com.example.cab.model.*;

@Service
public class UserService {
	
	@Autowired
	UserRepo ur1;
	@Autowired
    PasswordEncoder passwordEncoder;

    public User regUser(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return ur1.save(u);
    }

}
