package com.apimsa.labs.customer.domain.service;

import java.util.List;

import com.apimsa.labs.customer.domain.model.Customer;

public interface CustomerService {
	
	public List<Customer> findByCustomerPhone(String customerPhone);
	public List<Customer> findByCustomerId(String customerId);	

}
