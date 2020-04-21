package com.apimsa.lab.micpr.customer.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


import com.apimsa.lab.micpr.customer.domain.model.Customer;
import com.apimsa.lab.micpr.customer.domain.service.CustomerService;
import com.sun.el.stream.Stream;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonNumber;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



//Only inject the JWT token and the claims to @RequestScoped CDI beans, as you’ll get a DeploymentExcpetion otherwise
//@ApplicationScoped
@RequestScoped

//rest controller path
//you end up with the path / web app path / rest controller path).
@Path("/customers")  

//Limit the access for a resource to specific roles and achieve authorization with the 
//Common Security Annotations (JSR-250) (@RolesAllowed, @PermitAll, @DenyAll)

//@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

//OpenAPI
@Tag(name = "Customer services", description = "Customer Service")

public class CustomerController {

	 @Inject
	 private CustomerService customerService;
	 
	 
	 // For JWT security
		@Inject
	    private Principal principal;
	 
	    @Inject
	    private JsonWebToken jsonWebToken;
	 
	    // Below is not part of the standard JWT claims but you can add any additional metadata in your token.
	    //@Inject
	    //@Claim("administrator_id")
	    //private JsonNumber administrator_id;

	// End of for JWT security 
    
	 @GET
	 // JWT Auth - All can access this operation
	 @PermitAll
	 //OpenAPI
	 @Operation(
	            summary = "Get all customers",
	            description = "Get all customers")
	 @APIResponses(
		        value = {
		        		@APIResponse(
				            responseCode = "200",
				            description = "Customers",
				            content = @Content(
			                    schema = @Schema(implementation = Customer.class))
			            ),
						 @APIResponse(
				             responseCode = "404",
				             description = "Could not find Customer ",
				             content = @Content(mediaType = "text/plain")
				        )
		        }
			 )
	 //Metrics
	 @Timed(name = "get-all-customers",
	 	description = "Monitor the time getAll Method takes",
	 	unit = MetricUnits.MILLISECONDS,
	 	absolute = true)
	 //Fault tolerance
	 @Timeout(500)
	 @Fallback(fallbackMethod = "getAllFallback") 
	 public Response getAll() {
		 
		 System.out.println("Principal " + principal.getName() + " with roles " + jsonWebToken.getGroups());
		 System.out.println("Principal email " + jsonWebToken.getClaim("email"));
		 return Response.ok(customerService.getAll()).build();
	 }
	 
	 public Response getAllFallback() {
	        return Response.ok(new ArrayList()).build();
	    }
	
	 
	 @GET
	// All can access this operation
	 @PermitAll
	 @Path("{id}")
	 @Operation(
	            summary = "Get customer by id",
	            description = "Get customer by id")
	 @APIResponses(
		        value = {
					 @APIResponse(
					            responseCode = "200",
					            description = "Customer",
					            content = @Content(
					                    schema = @Schema(implementation = Customer.class))
					            ),
					 @APIResponse(
				             responseCode = "404",
				             description = "Could not find Customer ",
				             content = @Content(mediaType = "text/plain")
				             )
		        	}
		        )
	 public Response getCustomer(@PathParam("id") String id) {
		 System.out.println("Find customer by id: " + id);
		 Customer customer = customerService.findById(id);
		 return Response.ok(customer).build();
	 }
	 

	 @POST
	// Only those with "admin" role in JWT token can access this operation
	 //@RolesAllowed("admin")
	 @CircuitBreaker(delay = 2000, requestVolumeThreshold = 2, failureRatio=0.65, successThreshold = 3)
	 public Response create(Customer customer) {
		 customerService.create(customer);
		 return Response.ok().build();
	 }
	 
	 
	 @PUT
	 //@RolesAllowed("admin")
	 @Path("{id}")
	 //Metrics
	 @Counted(unit = MetricUnits.NONE,
		 name = "updateCustomer",
		 absolute = true,
		 displayName = "update Customer",
		 description = "Monitor how many times update customer method was called"
		 )
	 //Fault Tolerance
	 @Retry(maxRetries = 3, delay = 300)
	 public Response update(@PathParam("id") String id, Customer customer) {
	 Customer updateCustomer = customerService.findById(id);
	 updateCustomer.setCustomerName(customer.getCustomerName());
	 customerService.update(updateCustomer);
	 return Response.ok().build();
	 }
	 
	 @DELETE
	 //@RolesAllowed("admin")
	 @Path("{id}")
	 public Response delete(@PathParam("id") String id) {
	 Customer getCustomer = customerService.findById(id);
	 customerService.delete(getCustomer);
	 return Response.ok().build();
	 }
	 
	
}
