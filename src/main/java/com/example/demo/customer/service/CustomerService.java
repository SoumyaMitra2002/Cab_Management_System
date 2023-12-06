package com.example.demo.customer.service;

import java.util.List;

import com.example.demo.customer.model.Customer;

public interface CustomerService {
	Customer insertCustomer(Customer customer);
	Customer updateCustomer(Customer customer,Integer customerId);
	Customer deleteCustomer(Integer customerId);
	List<Customer> viewCustomers();
	Customer viewCustomer(Integer customerId);
	Customer validateCustomer(String username,String password);

}
