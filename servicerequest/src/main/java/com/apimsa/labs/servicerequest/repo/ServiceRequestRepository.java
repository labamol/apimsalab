package com.apimsa.labs.servicerequest.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
 


public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
	
	@Query("{serviceRequestId: '?0'}")
	public ServiceRequest findByServiceRequestId(String serviceRequestId);

	@Query("{serviceRequestCustomerId: '?0'}")
	public List<ServiceRequest> findByCustomerId(String customerId);
}

