package com.example.cab.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cab.model.*;

public interface UserRepo extends JpaRepository<User,Integer>{
	Optional<User> findByName(String name);


}
