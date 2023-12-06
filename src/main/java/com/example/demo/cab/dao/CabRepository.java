package com.example.demo.cab.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cab.model.Cab;


public interface CabRepository extends JpaRepository<Cab, Integer>{

	List<Cab> findByCabType(String type);
}
