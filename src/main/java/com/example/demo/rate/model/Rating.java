package com.example.demo.rate.model;

import com.example.demo.driver.model.Driver;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ratingId;
	@ManyToOne
	private Driver driverR;
	private String comment;
	private float ratingNo;
	private String commentUser;
	
	
	public Rating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public Driver getDriverR() {
		return driverR;
	}
	public void setDriverR(Driver driverR) {
		this.driverR = driverR;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public float getRatingNo() {
		return ratingNo;
	}
	public void setRatingNo(float ratingNo) {
		this.ratingNo = ratingNo;
	}
	
	public String getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(String commentUser) {
		this.commentUser = commentUser;
	}
	
	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", driverR=" + driverR + ", comment=" + comment + ", ratingNo="
				+ ratingNo + "]";
	}
	
}
