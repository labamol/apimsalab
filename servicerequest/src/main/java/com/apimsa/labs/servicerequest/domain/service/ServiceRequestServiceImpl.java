package com.apimsa.labs.servicerequest.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
import com.apimsa.labs.servicerequest.repo.ServiceRequestRepository;

public class ServiceRequestServiceImpl implements ServiceRequestService {

	@Autowired
	ServiceRequestRepository serviceRequestRepository;
	
	@Override
	public ServiceRequest findByServiceRequestId(String serviceRequestId) {
		return serviceRequestRepository.findByServiceRequestId(serviceRequestId);
	}

	@Override
	public String createServiceRequest(ServiceRequest serviceRequest) {
		serviceRequestRepository.save(serviceRequest);
		return null;
	}

}
