package com.example.demo.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.model.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Integer>{

    Customer findByEmailAndPassword(String username, String password);

}
