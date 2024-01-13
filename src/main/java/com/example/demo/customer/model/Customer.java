package com.example.demo.customer.model;

import java.util.List;

import com.example.demo.abstrct.model.AbsractUser;
import com.example.demo.image.model.Image;
import com.example.demo.trip.model.TripBooking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Customer extends AbsractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Image image;
	
	@OneToMany(mappedBy = "customer")
	private List<TripBooking> trips;

	public List<TripBooking> getTrips() {
		return trips;
	}

	public void setTrips(List<TripBooking> trips) {
		this.trips = trips;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId) {
		super();
		this.customerId = customerId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", image=" + image + "]";
	}
	
	
}
