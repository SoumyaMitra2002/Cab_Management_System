package com.example.demo.cab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cab.dao.CabRepository;
import com.example.demo.cab.model.Cab;
import com.example.demo.cab.service.CabService;

@Service
public class CabServiceImpl implements CabService{
	
	@Autowired
	private CabRepository cabRepository;
	

	@Override
	public Cab addCab(Cab cab) {
		return 	cabRepository.save(cab);

	}

	@Override
	public Cab updateCab(Cab cab, Integer cabId) {
		cab.setCabId(cabId);
		return cabRepository.save(cab);
	}

	@Override
	public Cab deleteCab(Integer cabId) {
		
		Cab cab=this.cabRepository.findById(cabId)
				.orElseThrow(()-> new RuntimeException());
		this.cabRepository.delete(cab);
		
		return cab;
	}

	@Override
	public List<Cab> viewCabsOfType(String cabType) {
		// TODO Auto-generated method stub
		return this.cabRepository.findByCabType(cabType);
	}

	@Override
	public Integer countCabsOfType(String cabType) {
		// TODO Auto-generated method stub
		return this.cabRepository.findAll().size();
	}

	@Override
	public List<Cab> viewAllCabs() {
		// TODO Auto-generated method stub
		return this.cabRepository.findAll();
	}

	@Override
	public Cab getSingleCab(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cab> cab=this.cabRepository.findById(id);
		
		if(cab.isPresent()) {
			return cab.get();
		}
		else {
			return null;
		}
	}

}
