package com.example.demo.cab.service;

import java.util.List;

import com.example.demo.cab.model.Cab;

public interface CabService {
	Cab addCab(Cab cab);
	Cab updateCab(Cab cab,Integer cabId);
	Cab deleteCab(Integer cabId);
	List<Cab> viewCabsOfType(String cabType);
	Integer countCabsOfType(String cabType);
	List<Cab> viewAllCabs();
	Cab getSingleCab(Integer id);
}
