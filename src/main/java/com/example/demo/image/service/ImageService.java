package com.example.demo.image.service;

import java.io.IOException;

import com.example.demo.image.model.Image;

public interface ImageService {
	
	 public byte[] getImgbyid(Integer id) throws IOException;
	 
	 Image saveImage(Image image);

}
