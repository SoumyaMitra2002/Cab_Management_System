package com.example.demo.driver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cab.model.Cab;
import com.example.demo.driver.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
	Driver findByCab(Cab cab);
	Driver findByEmailAndPassword(String email,String password);
}
