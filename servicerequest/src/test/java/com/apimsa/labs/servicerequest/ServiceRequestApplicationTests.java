package com.apimsa.labs.servicerequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimsa.labs.servicerequest.controller.ServiceRequestController;
import com.apimsa.labs.servicerequest.domain.model.ServiceRequest;
import com.apimsa.labs.servicerequest.repo.ServiceRequestRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest
public class ServiceRequestApplicationTests {
	
	
	@InjectMocks
    ServiceRequestController controller;

    @Mock
    ServiceRequestRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testController() {
		/**ServiceRequest req_1 = new ServiceRequest("100", "1", "2", "Joe", "01-01-2019", "05-01-2019");
		repository.save(req_1);
		
		this.controller.addServiceRequest(req_1);
        
        
		ServiceRequest req_2 = new ServiceRequest("101", "2", "1", "Mark", "01-01-2019", "05-01-2019");
		repository.save(req_2);
		
		this.controller.addServiceRequest(req_2);
		
		System.out.println(this.controller.findByServiceRequestId("100"));
		
		 //verify(repository.findByServiceRequestId("101");

	     // JUnit asserts
		 //assertEquals("Mark", controller.findByServiceRequestId("101").getServiceRequestAssignedTo());
	     
		 // Use hamcrest matchers , so above assertion is more readable as below
		 assertThat(this.controller.findByServiceRequestId("101").getServiceRequestAssignedTo(), is("Mark"));
		**/
	}

}
