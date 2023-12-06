package com.example.demo.driver.service;

import java.util.List;

import com.example.demo.cab.model.Cab;
import com.example.demo.driver.model.Driver;

public interface DriverService {
	Driver addDriver(Driver driver);
	Driver updateDriver(Driver driver,Integer driverId);
	Driver deleteDriver(Integer driverId);
	List<Driver> viewBestDriver();
	Driver viewDriver(Integer driverId);
	Driver findDriverByCab(Cab cab);
	Driver validateDriver(String email,String password);

}
