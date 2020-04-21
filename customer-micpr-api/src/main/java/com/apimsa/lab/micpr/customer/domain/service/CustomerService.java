package com.apimsa.lab.micpr.customer.domain.service;

import java.util.List;

import com.apimsa.lab.micpr.customer.domain.model.Customer;

public interface CustomerService {

	
    public List<Customer> getAll() ;

    public Customer findById(String id) ;

    public void update(Customer customer) ;

    public void create(Customer customer) ;
    	
    public void delete(Customer customer) ;
}
