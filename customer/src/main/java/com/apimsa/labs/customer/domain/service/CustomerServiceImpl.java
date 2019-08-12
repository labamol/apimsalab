package com.apimsa.labs.customer.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apimsa.labs.customer.domain.model.Customer;
import com.apimsa.labs.customer.repo.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findByCustomerPhone(String customerPhone) {		
		return customerRepository.findByCustomerPhone(customerPhone); 
	}

	@Override
	public List<Customer> findByCustomerId(String customerId) {
		return customerRepository.findByCustomerId(customerId);
	}

}
