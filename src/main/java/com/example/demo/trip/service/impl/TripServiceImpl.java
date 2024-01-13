package com.example.demo.trip.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.model.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.trip.dao.TripRepository;
import com.example.demo.trip.model.TripBooking;
import com.example.demo.trip.service.TripService;

@Service
public class TripServiceImpl implements TripService{
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private CustomerService customerService;

	@Override
	public TripBooking insertTripBooking(TripBooking tripBooking) {
		return tripRepository.save(tripBooking);
	}

	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking, Integer tripId) {
		tripBooking.setTripBookingId(tripId);
		return tripRepository.save(tripBooking);
	}

	@Override
	public TripBooking deleteTripBooking(Integer tripId) {
		Optional<TripBooking> tripBooking=tripRepository.findById(tripId);
		if(tripBooking.isPresent()) {
			TripBooking trip=tripBooking.get();
			tripRepository.delete(trip);
			return trip;
		}
		else {
			return null;
		}
	}

	@Override
	public List<TripBooking> viewAllTripCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Customer customer=customerService.viewCustomer(customerId);
		return tripRepository.findByCustomer(customer);
	}

	@Override
	public TripBooking calculateBill(Integer tripId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBooking> viewAllTrips() {
		// TODO Auto-generated method stub
		
		return tripRepository.findAll();
	}

	@Override
	public TripBooking viewTrip(Integer tripId) {
		
		Optional<TripBooking> tripBooking=tripRepository.findById(tripId);
		if(tripBooking.isPresent()) {
			TripBooking trip=tripBooking.get();
			return trip;
		}
		else {
			return null;
		}
		
	}

}
