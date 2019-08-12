package com.apimsa.labs.servicerequest.domain.service;


import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;

public interface ServiceRequestService {
	
	public ServiceRequest findByServiceRequestId(String serviceRequestId);
	public String createServiceRequest(ServiceRequest serviceRequest);	

}
