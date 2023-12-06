package com.example.demo.location.service;

import java.util.List;

import com.example.demo.location.model.Location;

public interface LocationService {
	public Location getLocationById(Integer locationId);
	public List<Location> getAllLocation();
	public Location addLocation(Location location);
	
}
