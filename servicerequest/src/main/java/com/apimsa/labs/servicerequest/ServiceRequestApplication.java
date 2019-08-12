package com.apimsa.labs.servicerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
import com.apimsa.labs.servicerequest.repo.ServiceRequestRepository;

@SpringBootApplication
public class ServiceRequestApplication {

	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceRequestApplication.class, args);
	
	}
	
	public void run(String[] args) throws Exception {
			clearData();
			saveData();
			lookup();
		}
		
		public void clearData(){
			serviceRequestRepository.deleteAll();
		}
		
		public void saveData(){
			System.out.println("===================Save servicerequests to mongo db===================");
			ServiceRequest req_1 = new ServiceRequest("1", "1", "2", "A", "01-01-2019", "05-01-2019");
	       	 
	        // save servicerequests 
	        serviceRequestRepository.save(req_1);

		}
		
		public void lookup(){
			System.out.println("===================Lookup servicerequests from mongo db by id===================");
			ServiceRequest serviceRequest = serviceRequestRepository.findByServiceRequestId("1");
			System.out.println(serviceRequest);

		}
	
		
		
		
	}
