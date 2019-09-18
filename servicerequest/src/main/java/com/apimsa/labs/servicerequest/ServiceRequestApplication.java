package com.apimsa.labs.servicerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.apimsa.labs.servicerequest.repo.ServiceRequestRepository;

@SpringBootApplication
//@EnableMongoRepositories("com.apimsa.labs.servicerequest.repo")
public class ServiceRequestApplication {

	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceRequestApplication.class, args);
	
	}
		
	}
