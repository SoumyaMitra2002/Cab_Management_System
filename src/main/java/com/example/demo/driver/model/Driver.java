package com.example.demo.driver.model;

import java.util.List;

import com.example.demo.abstrct.model.AbsractUser;
import com.example.demo.cab.model.Cab;
import com.example.demo.image.model.Image;
import com.example.demo.rate.model.Rating;
import com.example.demo.trip.model.TripBooking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Driver extends AbsractUser{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer driverId;
	private String licenceNo;
	@Transient
	private float rating;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cab cab;
	
	@OneToMany(mappedBy = "driver")
	private List<TripBooking> tripBooking;

	@OneToOne(cascade = CascadeType.ALL)
	private Image image;
	
	@OneToMany(mappedBy = "driverR",cascade = CascadeType.ALL)
	private List<Rating> rates;
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Driver() {
		super();
	}

	public Driver(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);

	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public float getRating() {
		int num=this.rates.size();
		float total=0;
		for(Rating r: this.rates) {
			total+=r.getRatingNo();
		}
		float result=(total*10)/(num*10);
		return result;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public List<TripBooking> getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(List<TripBooking> tripBooking) {
		this.tripBooking = tripBooking;
	}

	public List<Rating> getRates() {
		return rates;
	}

	public void setRates(List<Rating> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + ", cab=" + cab
				+ ", tripBooking=" + tripBooking + ", image=" + image + ", rates=" + rates + "]";
	}
	
	
	
	
	
}

