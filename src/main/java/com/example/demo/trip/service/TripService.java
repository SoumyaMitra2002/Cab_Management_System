package com.example.demo.trip.service;

import java.util.List;

import com.example.demo.trip.model.TripBooking;

public interface TripService {
	
	TripBooking insertTripBooking(TripBooking tripBooking);
	TripBooking updateTripBooking(TripBooking tripBooking,Integer tripId);
	TripBooking deleteTripBooking(Integer tripId);
	List<TripBooking> viewAllTripCustomer(Integer customerId);
	TripBooking calculateBill(Integer tripId);
	List<TripBooking> viewAllTrips();

}
