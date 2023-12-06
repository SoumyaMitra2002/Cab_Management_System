package com.example.demo.image.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.image.dao.ImageRepository;
import com.example.demo.image.model.Image;
import com.example.demo.image.service.ImageService;
import com.example.demo.utils.MyUtils;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageRepository repo;
	
	@Override
	public byte[] getImgbyid(Integer id) throws IOException {
		// TODO Auto-generated method stub
		 Image image=this.repo.findById(id).orElseThrow(()->new RuntimeException("Image not found"));
	        byte[] res= MyUtils.decompressImage(image.getData());
	        return res;
	}

	@Override
	public Image saveImage(Image image) {
		// TODO Auto-generated method stub
		return this.repo.save(image);
	}

}
