package com.apimsa.labs.servicerequest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
import com.apimsa.labs.servicerequest.domain.service.ServiceRequestService;


@RestController
// set baseUrl of API to /servicerequest
@RequestMapping("/servicerequest")
public class ServiceRequestController {

	@Autowired
    private ServiceRequestService service;

    @RequestMapping(value = "/{servicerequestId}",method = RequestMethod.GET, produces = "application/json")
    public ServiceRequest findByServiceRequestId(@PathVariable(value="servicerequestId") String serviceRequestId) {
      return service.findByServiceRequestId(serviceRequestId);
    } 
    
    @RequestMapping(value = "/customer/{customerId}",method = RequestMethod.GET, produces = "application/json")
    public List<ServiceRequest> findByCustomerId(@PathVariable(value="customerId") String customerId) {
      return service.findByCustomerId(customerId);
    } 

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String addServiceRequest(@RequestBody ServiceRequest serviceRequest) {
      return service.createServiceRequest(serviceRequest);
    } 
	
}
