package com.apimsa.labs.servicerequest.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
 
import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;


public interface ServiceRequestRepository extends MongoRepository<ServiceRequest, String> {
	 
	@Query(value = "{'servicerequest.serviceRequestId': ?0}", fields = "{'servicerequest' : 0}")
	public ServiceRequest findByServiceRequestId(String serviceRequestId);
}

