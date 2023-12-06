package com.example.demo.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.location.model.Location;
import com.example.demo.location.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	private String getAllLocation(Model model) {
		List<Location> list=locationService.getAllLocation();
		model.addAttribute("list",list);
		model.addAttribute("u","not_added");
		return "location/All_locations";
	}
	
	@GetMapping("/addlocation")
	private String locationForm() {
		return "location/locationform";
	}
	
	@PostMapping("/addprocess")
	private String addProcess(
			@RequestParam("name") String locationName,
			@RequestParam("alt") Integer alt,
			Model model) {
		Location location=new Location();
		location.setLocationName(locationName);
		location.setAltitude(alt);
		locationService.addLocation(location);
		List<Location> list=locationService.getAllLocation();
		model.addAttribute("list",list);
		model.addAttribute("u","added");
		return "location/All_locations";
	}
	
	
	
	

}
