package com.example.demo.customer.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.dao.CustomerRepository;
import com.example.demo.customer.model.Customer;
import com.example.demo.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer customerId) {
		customer.setCustomerId(customerId);
		return customerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomer(Integer customerId) {
		Optional<Customer> customer =customerRepository.findById(customerId);
		if(customer.isPresent()) {
			Customer customer1=customer.get();
			customerRepository.delete(customer1);
			return customer1;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Customer> viewCustomers() {
		
		return customerRepository.findAll();
	}

	@Override
	public Customer viewCustomer(Integer customerId) {
		Optional<Customer> customer =customerRepository.findById(customerId);
		if(customer.isPresent()) {
			Customer customer1=customer.get();
			return customer1;
		}
		else {
			return null;
		}
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmailAndPassword(username, password);
	}

}
