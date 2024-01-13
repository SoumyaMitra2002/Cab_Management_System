package com.example.demo.customer.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.customer.dao.CustomerRepository;
import com.example.demo.customer.model.Customer;
import com.example.demo.customer.service.CustomerService;
import com.example.demo.customer.service.impl.CustomerServiceImpl;
import com.example.demo.driver.model.Driver;
import com.example.demo.driver.service.DriverService;
import com.example.demo.image.model.Image;
import com.example.demo.location.model.Location;
import com.example.demo.location.service.LocationService;
import com.example.demo.rate.dao.RateRepository;
import com.example.demo.rate.model.Rating;
import com.example.demo.trip.model.TripBooking;
import com.example.demo.trip.service.TripService;
import com.example.demo.utils.MyUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TripService tripService;
	
	@Autowired
	private RateRepository rateRepository;
	
	
//	@GetMapping("/test")
//	public String saveCustomer() {
//		Customer cust=new Customer();
//		cust.setUsername("Mitra");
//		cust.setAddress("kgp");
//		cust.setPassword("123");
//		cust.setEmail("gamil.com");
//		cust.setMobileNumber("123456");
//		
//		this.dao.save(cust);
//		
//		return "";
//	}
	
	@GetMapping("/signup")
	public String getSignUp() {
		return "customer/customersignup";
	}
	
	@PostMapping("/signupprocess")
	public String signUpProcess(
			@RequestParam("name") String username,
			@RequestParam("email") String email,
			@RequestParam("pwd") String password,
			@RequestParam("address") String address,
			@RequestParam("phonenumber") String phoneNumber,
			@RequestParam("file") MultipartFile file,
			Model model
			) throws IOException {
		Image image=new Image();
		image.setContentType(file.getContentType());
		image.setName(file.getName());
		image.setData(MyUtils.compressImage(file.getBytes(),"jpg", 0.5f));
		
		Customer customer=new Customer();
		customer.setUsername(username);
		customer.setEmail(email);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setMobileNumber(phoneNumber);
		customer.setImage(image);
		Customer temp4=customerService.insertCustomer(customer);
		
		model.addAttribute("u","register");
		if(temp4!=null) {
			return "success";
		}
		else {
			return "fail";
		}
		
	}
	 
	@GetMapping("/success")
	public String successPage(Model model) {
		 	return "success"; // Return the success page view name (success.html)
	}
	
	@GetMapping("/login_customer")
	public String customerLogin() {
		return "customer/loginpage";
	}
	
	@PostMapping("/loginprocess")
	public String loginValidate(
			@RequestParam("username") String email,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		Customer customer=customerService.validateCustomer(email, password);
		if(customer==null) {
			return "customer/customer_redir";
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("customer", customer);
			return "customer/dashboard";
		}
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable Integer id,Model model) {
		Customer customer=customerService.viewCustomer(id);
		model.addAttribute("customer",customer);
		return "customer/details";
	}
	
	@GetMapping("/addtrip")
	public String addTrip(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		List<Location> list=locationService.getAllLocation();
		List<Driver> listf=driverService.viewBestDriver();
		model.addAttribute("locations",list);
		model.addAttribute("drivers",listf);
		
		return "customer/add_trip";
	}
	
	@PostMapping("/trip_process")
	public String addTripProcess(
			@RequestParam("drivers") Integer driverId,
			@RequestParam("source") Integer sourceId,
			@RequestParam("destination") Integer destinationId,Model model) {
		Location source=locationService.getLocationById(sourceId);
		Location destination=locationService.getLocationById(destinationId);
		List<Location> list=locationService.getAllLocation();
		List<Driver> listf=driverService.viewBestDriver();
		Driver driver=driverService.viewDriver(driverId);
		model.addAttribute("locations",list);
		model.addAttribute("drivers",listf);
		model.addAttribute("src",source);
		model.addAttribute("dest",destination);
		model.addAttribute("dri",driver);
		int fare=(Math.abs((source.getAltitude()-destination.getAltitude()) )+ 3) * driver.getCab().getPerKmRate();
		model.addAttribute("fare",fare);
		if(source==destination) {
			return "customer/redir";
		}
		return "customer/confirmtrip";
	}
	
	@PostMapping("/finalprocess")
	public String finalProcess(
			@RequestParam("customer") Integer customerId,
			@RequestParam("src") Integer loca1Id,
			@RequestParam("dest") Integer loca2Id,
			@RequestParam("fare")Integer fare,
			@RequestParam("driver") Integer driverId){
		LocalDate dt = java.time.LocalDate.now();
		LocalDate dt2 = dt.plusDays(Math.abs(this.locationService.getLocationById(loca1Id).getAltitude()-this.locationService.getLocationById(loca2Id).getAltitude()));
		String d2=dt2.toString();
	    String d = dt.toString();
//		System.out.println(customerId);
//		System.out.println(loca1Id);
//		System.out.println(loca2Id);
//		System.out.println(fare);
//		System.out.println(driverId);
		TripBooking tripBooking=new TripBooking();
		tripBooking.setCustomer(this.customerService.viewCustomer(customerId));
		tripBooking.setBill((float)fare);
		tripBooking.setFromLocation(this.locationService.getLocationById(loca1Id).getLocationName());
		tripBooking.setToLocation(this.locationService.getLocationById(loca2Id).getLocationName());
		tripBooking.setCustomer(customerService.viewCustomer(customerId));
		tripBooking.setDriver(driverService.viewDriver(driverId));
		tripBooking.setFromDateTime(d);
		tripBooking.setToDateTime(d2);
		tripService.insertTripBooking(tripBooking);
		
		return "customer/success";
	}
	
	@GetMapping("/dashboard")
	private String getDashboard(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.setAttribute("customer", (Customer) session.getAttribute("customer"));
		return "customer/dashboard";
		
	}
	
	
	@GetMapping("/history")
	private String getTripHistory(Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		Customer customer=(Customer)session.getAttribute("customer");
		List<TripBooking> list=tripService.viewAllTripCustomer(customer.getCustomerId());
		model.addAttribute("list",list);
		return "customer/history_trip";
	}
	
	@GetMapping("/viewallcustomer")
	private String customers(Model model) {
		List<Customer> customers=customerService.viewCustomers();
//		for(Customer customer: customers) {
//			List<TripBooking> trips=tripService.viewAllTripCustomer(customer.getCustomerId());
//			customer.setTrips(trips);
//		}
		HashMap<Integer,Float> map=new HashMap<Integer, Float>();
		for(Customer customer: customers) {
			
			System.out.println(customer+" "+customer.getTrips().size());
			float total=0;
			for(TripBooking trip:customer.getTrips()) {
				total+=trip.getBill();
			}
			map.put(customer.getCustomerId(),total);
		}
		model.addAttribute("list1",customers);
		model.addAttribute("list2",map);
		
		return "customer/customers";
	}
	
	@GetMapping("/feedback/{id}")
	private String getRatePage(@PathVariable int id,Model model) {
		TripBooking trip=tripService.viewTrip(id);
		Driver driver=trip.getDriver();
		Customer customer=trip.getCustomer();
		model.addAttribute("driver",driver);
		model.addAttribute("customer",customer);
		model.addAttribute("tripid",id);
		return "customer/feedback";
	}
	
	@PostMapping("/rateprocess")
	private String rate(@RequestParam("driverid") Integer driverId,
			@RequestParam("customername") String commentUser,
			@RequestParam("tripid") Integer tripId,
			@RequestParam("rate") Float rate,
			@RequestParam("msg") String msg
			) {
		Rating rate1=new Rating();
		rate1.setRatingNo(rate);
		rate1.setComment(msg);
		rate1.setCommentUser(commentUser);
		rate1.setDriverR(driverService.viewDriver(driverId));
		rateRepository.save(rate1);
		TripBooking trip=tripService.viewTrip(tripId);
		trip.setRated(true);
		tripService.insertTripBooking(trip);
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	


}
