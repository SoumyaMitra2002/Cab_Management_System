package com.example.demo.cab.model;

import com.example.demo.driver.model.Driver;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cabId;
	private String cabType;
	private Integer perKmRate;
	
	@OneToOne
	private Driver driver;

	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cab(Integer cabId, String cabType, Integer perKmRate, Driver driver) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.perKmRate = perKmRate;
		this.driver = driver;
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public Integer getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(Integer perKmRate) {
		this.perKmRate = perKmRate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	

}
