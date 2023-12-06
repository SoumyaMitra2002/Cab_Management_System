package com.example.demo.trip.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.model.Customer;
import com.example.demo.trip.model.TripBooking;

public interface TripRepository extends JpaRepository<TripBooking, Integer>{
	
	
	List<TripBooking> findByCustomer(Customer customer);

}
