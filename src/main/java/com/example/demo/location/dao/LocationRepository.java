package com.example.demo.location.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.location.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
