package com.example.demo.image.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.image.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
