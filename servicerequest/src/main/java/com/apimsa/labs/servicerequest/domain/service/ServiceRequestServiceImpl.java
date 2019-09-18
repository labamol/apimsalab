package com.apimsa.labs.servicerequest.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
import com.apimsa.labs.servicerequest.repo.ServiceRequestRepository;

@Service
//@EnableMongoRepositories("com.apimsa.labs.servicerequest.repo")
public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	@Override
	public ServiceRequest findByServiceRequestId(String serviceRequestId) {
		System.out.println("Hi, Service Request has " + serviceRequestRepository.count() + "entries");
		return serviceRequestRepository.findByServiceRequestId(serviceRequestId);
		
	}

	@Override
	public String createServiceRequest(ServiceRequest serviceRequest) {
		serviceRequestRepository.save(serviceRequest);
		return null;
	}

	@Override
	public List<ServiceRequest> findByCustomerId(String customerId) {
		System.out.println("Hi, Service Request has " + serviceRequestRepository.count() + "entries");
		return serviceRequestRepository.findByCustomerId(customerId);
	}

}
