package com.example.demo.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.location.dao.LocationRepository;
import com.example.demo.location.model.Location;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location getLocationById(Integer locationId) {
		Optional<Location> opt=locationRepository.findById(locationId);
		if(opt.isPresent()) {
			return opt.get();		
		}
		else {
			return null;
		}
	}

	@Override
	public List<Location> getAllLocation() {
		List<Location> list=locationRepository.findAll();
		return list;
	}

	@Override
	public Location addLocation(Location location) {
		Location loc=locationRepository.save(location);
		return loc;
	}

}
