package com.example.demo.rate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.rate.model.Rating;

public interface RateRepository extends JpaRepository<Rating, Integer>{

}
