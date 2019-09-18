package com.apimsa.labs.servicerequest.domain.service;


import java.util.List;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;

public interface ServiceRequestService {
	
	public ServiceRequest findByServiceRequestId(String serviceRequestId);
	public List<ServiceRequest> findByCustomerId(String customerId);
	public String createServiceRequest(ServiceRequest serviceRequest);	

}
