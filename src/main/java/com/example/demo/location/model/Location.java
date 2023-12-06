package com.example.demo.location.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer locationId;
	
	@Column(unique = true)
	private Integer altitude;
	private String locationName;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Location(Integer altitude, String locationName) {
		super();
		this.altitude = altitude;
		this.locationName = locationName;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Integer getAltitude() {
		return altitude;
	}
	public void setAltitude(Integer altitude) {
		if(altitude<=1) {
			this.altitude= altitude * -1;
		}
		this.altitude = altitude;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	
	
	
	
}
