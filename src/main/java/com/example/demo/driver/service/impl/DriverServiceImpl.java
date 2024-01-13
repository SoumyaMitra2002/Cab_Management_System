package com.example.demo.driver.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cab.model.Cab;
import com.example.demo.driver.dao.DriverRepository;
import com.example.demo.driver.model.Driver;
import com.example.demo.driver.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService{
	
	@Autowired
	private DriverRepository driverRepository;

	@Override
	public Driver addDriver(Driver driver) {
		
		return driverRepository.save(driver);
	}

	@Override
	public Driver updateDriver(Driver driver, Integer driverId) {
		driver.setDriverId(driverId);
		
		return driverRepository.save(driver);
	}

	@Override
	public Driver deleteDriver(Integer driverId) {
		Driver driver=this.driverRepository.findById(driverId)
				.orElseThrow(()-> new RuntimeException());
		this.driverRepository.delete(driver);
		
		return driver;
	}

	@Override
	public List<Driver> viewBestDriver() {
		
		List<Driver> res=this.driverRepository.findAll();
//        res.sort((o1, o2) -> Float.compare(o2.getRating(), o1.getRating()));
        
        return res;

	}

	@Override
	public Driver viewDriver(Integer driverId) {
		// TODO Auto-generated method stub
		return this.driverRepository.findById(driverId)
				.orElseThrow(()-> new RuntimeException());
	}

	@Override
	public Driver findDriverByCab(Cab cab) {
		// TODO Auto-generated method stub
		return this.driverRepository.findByCab(cab);
	}

	@Override
	public Driver validateDriver(String email, String password) {
		// TODO Auto-generated method stub
		return this.driverRepository.findByEmailAndPassword(email, password);
	}

}
