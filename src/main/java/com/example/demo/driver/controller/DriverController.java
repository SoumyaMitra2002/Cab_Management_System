package com.example.demo.driver.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.cab.model.Cab;
import com.example.demo.cab.service.CabService;
import com.example.demo.driver.model.Driver;
import com.example.demo.driver.service.DriverService;
import com.example.demo.image.model.Image;
import com.example.demo.image.service.ImageService;
import com.example.demo.utils.MyUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private CabService cabService;
	
	@GetMapping("/signup")
	private String getDriverSignUp() {
		return "driver/signup";
	}
	
	@PostMapping("/add")
	private String addDriver(
			@RequestParam("name") String userName,
			@RequestParam("email") String email,
			@RequestParam("pwd") String password,
			@RequestParam("address") String address,
			@RequestParam("licenceno") String licenceNo,
			@RequestParam("phonenumber") String mobileNumber,
			@RequestParam("perkmrate") Integer perKmRate,
			@RequestParam("cab") String cabType,
			@RequestParam("file") MultipartFile file,Model model) throws IOException {
		
		String type=file.getContentType();
		
		if(!type.equals("image/jpg") && !type.equals("image/jpeg")) {
			System.out.println(type);
			return "driver/img";
			
		}
		
		Image image=new Image();
		image.setName(file.getName());
		image.setContentType(file.getContentType());
		byte[] data=MyUtils.compressImage(file.getBytes(), "jpg", 0.5f);
		image.setData(data);
		
		Image image2=this.imageService.saveImage(image);
		
		Cab cab=new Cab();
		cab.setCabType(cabType);
		cab.setPerKmRate(perKmRate);
		Driver driver=new Driver();
		driver.setUsername(userName);
		driver.setEmail(email);
		driver.setPassword(password);
		driver.setAddress(address);
		driver.setLicenceNo(licenceNo);
		driver.setMobileNumber(mobileNumber);
		driver.setCab(cab);
		driver.setImage(image2);
		Driver tempf= driverService.addDriver(driver);
		if(tempf!=null) {
			return "driver_success";
		}
		else {
			return "driver_fail";
		}
	}
	
	@GetMapping("/login")
	private String getLoginPage() {
		return "driver/driver_login";
	}
	
	@PostMapping("/loginprocess")
	private String validateDriver(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		Driver driver=driverService.validateDriver(email, password);
		if(driver==null) {
			return "driver/driver_redir";
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("driver", driver);
			return "driver/dashboard";
		}
	}
}
