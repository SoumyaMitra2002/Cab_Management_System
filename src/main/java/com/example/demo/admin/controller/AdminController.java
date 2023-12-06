package com.example.demo.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ImageService imageservice;
	
	@Autowired
	private CabService cabService;
	
	@Autowired
	private DriverService driverService;
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "admin/admin_login";
	}
	
	@PostMapping("/adminloginprocess")
	public String adminLoginProcess(
			@RequestParam("username") String userName,
			@RequestParam("password")String password
			) {
		
		if(!userName.equals("admin@gmail.com") || !password.equals("12345") )
		{
			return "admin/redir";
		}
		else {
			return "admin/dashboard";
		}
	}
	
	
	@GetMapping("/drivers")
	public String getAllDrivers(Model model) {
		
		List<Driver> drivers=driverService.viewBestDriver();
		model.addAttribute("drivers",drivers);
		return "driver/alldrivers";
	}
	
	@GetMapping("/adddriver")
	public String getAddDriverForm() {
		return "driver/addDriverForm";
	}
	
	@PostMapping("/driverprocess")
	public String driverProcess(
			@RequestParam("name") String userName,
			@RequestParam("email") String emailAddress,
			@RequestParam("pwd") String password,
			@RequestParam("address") String address,
			@RequestParam("licenceno") String licenceNo,
			@RequestParam("phonenumber") String phoneNumber,
			@RequestParam("perkmrate") Integer perKmRate,
			@RequestParam("cab") String cabType,
			@RequestParam("file") MultipartFile file,
			Model model
			) throws IOException{
	
		
		String type=file.getContentType();
		
		if(!type.equals("image/jpg") && !type.equals("image/jpeg")) {
			System.out.println(type);
			return "driver/img";
			
		}
		
		Image image=new Image();
		image.setName(file.getName());
		image.setContentType(file.getContentType());
		byte[] data=MyUtils.compressImage(file.getBytes(),"jpg", 0.5f);
		image.setData(data);
		
		Image tempImage=this.imageservice.saveImage(image);
		
		Cab cab=new Cab();
		cab.setCabType(cabType);
		cab.setPerKmRate(perKmRate);
		cabService.addCab(cab);
		Driver driver=new Driver();
		driver.setEmail(emailAddress);
		driver.setAddress(address);
		driver.setMobileNumber(phoneNumber);
		driver.setLicenceNo(licenceNo);
		driver.setPassword(password);
		driver.setUsername(userName);
		driver.setCab(cab);
		driver.setImage(tempImage);
		Driver temp1=driverService.addDriver(driver);
		String temp=temp1.getUsername();
		model.addAttribute("temp", temp);
		
		List<Driver> drivers=driverService.viewBestDriver();
		model.addAttribute("drivers",drivers);
		model.addAttribute("update", "added");
	
		return "driver/driver_allinone";
	}
	
	@GetMapping("/aboutdriver/{id}")
	public String aboutDriver(@PathVariable("id") Integer driverId,Model model) {
		Driver driverOne=driverService.viewDriver(driverId);
		model.addAttribute("driverOne",driverOne);
		return "driver/aboutdriver";
	}
	
	@GetMapping("/deletedriver/{id}")
	public String deleteDriver(@PathVariable("id") Integer driverId,Model model) {
		Driver driverTwo=driverService.viewDriver(driverId);
		String temp=driverTwo.getUsername();
		model.addAttribute("driverTwo",driverTwo);
		driverService.deleteDriver(driverId);
		model.addAttribute("temp",temp);
		model.addAttribute("update", "deleted");
		
		List<Driver> drivers=driverService.viewBestDriver();
		model.addAttribute("drivers",drivers);

		return "driver/driver_allinone";
	}
	
	@GetMapping("/editdriver/{id}")
	public String editDriver(@PathVariable("id") Integer driverId,Model model) {
		Driver driverThree=driverService.viewDriver(driverId);
		model.addAttribute("driverThree",driverThree);
		return "driver/editdriver";
	}
	
	
	@PostMapping("/driverupdate")
	public String driverUpdate(
			@RequestParam("name") String userName,
			@RequestParam("email") String emailAddress,
			@RequestParam("phonenumber") String phoneNumber,	
			@RequestParam("address") String address,
			@RequestParam("file") MultipartFile file,
			@RequestParam("id") Integer id,
			Model model
			) throws IOException {
			
		Driver driverOrg=driverService.viewDriver(id);
		
		
		Image image=new Image();
		image.setContentType(file.getContentType());
		image.setName(file.getName());
		image.setData(MyUtils.compressImage(file.getBytes(),"jpg", 0.5f));
		
		Image saved= imageservice.saveImage(image);
		
		
		driverOrg.setImage(saved);
		
		driverOrg.setUsername(userName);
		driverOrg.setEmail(emailAddress);
		driverOrg.setAddress(address);
		driverOrg.setMobileNumber(phoneNumber);
		
		Driver temp1=driverService.addDriver(driverOrg);
		String temp=temp1.getUsername();
		model.addAttribute("temp", temp);
		
		List<Driver> drivers=driverService.viewBestDriver();
		model.addAttribute("drivers",drivers);
		model.addAttribute("update", "updated");
	
		return "driver/driver_allinone";
		
		
	}
	
	
	@GetMapping("/cabs")
	public String cabs(Model model) {
		
		List<Cab> cabs=this.cabService.viewAllCabs();
		
		
		List<Cab> list_cab=new ArrayList<Cab>();
		
		for(Cab b: cabs) {
			Driver d=this.driverService.findDriverByCab(b);
			b.setDriver(d);
			list_cab.add(b);
		}
		model.addAttribute("u","not_updated");
		model.addAttribute("list_cab",list_cab);
		return "cab/cabs";
	}
	
	@GetMapping("/editcab/{id}")
	public String provideUpdateForm(@PathVariable("id") Integer id,Model model) {
		Cab cab=this.cabService.getSingleCab(id);
		model.addAttribute("cab", cab);
		return "cab/updateform";
		
	}
	
	@PostMapping("/cabupdate")
	public String cabUpdate(
			@RequestParam("perkmrate") Integer perKmRate,
			@RequestParam("cabtype") String cabType,
			@RequestParam("id") Integer cabId,
			Model model
			) {
		Cab cab=cabService.getSingleCab(cabId);
		
		cab.setCabType(cabType);
		cab.setPerKmRate(perKmRate);
		
		Cab temp1=cabService.addCab(cab);
		
		List<Cab> cabs=this.cabService.viewAllCabs();
		
		
		List<Cab> list_cab=new ArrayList<Cab>();
		
		for(Cab b: cabs) {
			Driver d=this.driverService.findDriverByCab(b);
			b.setDriver(d);
			list_cab.add(b);
		}
		
		model.addAttribute("list_cab",list_cab);
		String u="updated";
		model.addAttribute("u",u);
		
		return "cab/cabs";
	}
	
}
