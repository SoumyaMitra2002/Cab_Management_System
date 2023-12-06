package com.example.demo.admin.model;

import com.example.demo.abstrct.model.AbsractUser;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin extends AbsractUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String address, String mobileNumber, String email) {
		super(username, password, address, mobileNumber, email);
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
	
}
