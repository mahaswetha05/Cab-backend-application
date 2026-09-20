package com.example.cab.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cab.model.*;
import com.example.cab.dao.*;


@Service

public class CustomerUserDetailService implements UserDetailsService {
	@Autowired
	UserRepo p;

	/*@Override*/
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		User u=p.findByName(name).orElseThrow(()->new UsernameNotFoundException("user not found"));
		return org.springframework.security.core.userdetails.User
				.withUsername(u.getName())
				.password(u.getPassword())
				.roles(u.getRole().name())
				.build();

}

}
