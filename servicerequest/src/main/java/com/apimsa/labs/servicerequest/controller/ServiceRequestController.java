package com.apimsa.labs.servicerequest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
import com.apimsa.labs.servicerequest.domain.service.ServiceRequestService;



@RestController
public class ServiceRequestController {

	@Autowired
    private ServiceRequestService service;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ServiceRequest findByServiceRequestId(@RequestParam(value="servicerequestId") String serviceRequestId) {
      return service.findByServiceRequestId(serviceRequestId);
    } 

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String addServiceRequest(@RequestBody ServiceRequest serviceRequest) {
      return service.createServiceRequest(serviceRequest);
    } 
	
}
