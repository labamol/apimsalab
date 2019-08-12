package com.apimsa.labs.servicerequest.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="servicerequest")
public class ServiceRequest {
	
	@Id
	private String serviceRequestId;
	private String serviceRequestCustomerId;
	private String serviceRequestSeverity;
	private String serviceRequestAssignedTo;
	private String serviceRequestRaisedOn;
	private String serviceRequestClosedOn;
		

	
	
	public ServiceRequest(String serviceRequestId, String serviceRequestCustomerId, String serviceRequestSeverity,
			String serviceRequestAssignedTo, String serviceRequestRaisedOn, String serviceRequestClosedOn) {
		super();
		this.serviceRequestId = serviceRequestId;
		this.serviceRequestCustomerId = serviceRequestCustomerId;
		this.serviceRequestSeverity = serviceRequestSeverity;
		this.serviceRequestAssignedTo = serviceRequestAssignedTo;
		this.serviceRequestRaisedOn = serviceRequestRaisedOn;
		this.serviceRequestClosedOn = serviceRequestClosedOn;
	}




	public String getServiceRequestId() {
		return serviceRequestId;
	}




	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}




	public String getServiceRequestCustomerId() {
		return serviceRequestCustomerId;
	}




	public void setServiceRequestCustomerId(String serviceRequestCustomerId) {
		this.serviceRequestCustomerId = serviceRequestCustomerId;
	}




	public String getServiceRequestSeverity() {
		return serviceRequestSeverity;
	}




	public void setServiceRequestSeverity(String serviceRequestSeverity) {
		this.serviceRequestSeverity = serviceRequestSeverity;
	}




	public String getServiceRequestAssignedTo() {
		return serviceRequestAssignedTo;
	}




	public void setServiceRequestAssignedTo(String serviceRequestAssignedTo) {
		this.serviceRequestAssignedTo = serviceRequestAssignedTo;
	}




	public String getServiceRequestRaisedOn() {
		return serviceRequestRaisedOn;
	}




	public void setServiceRequestRaisedOn(String serviceRequestRaisedOn) {
		this.serviceRequestRaisedOn = serviceRequestRaisedOn;
	}




	public String getServiceRequestClosedOn() {
		return serviceRequestClosedOn;
	}




	public void setServiceRequestClosedOn(String serviceRequestClosedOn) {
		this.serviceRequestClosedOn = serviceRequestClosedOn;
	}




	@Override
	public String toString() {
		return String.format("servicerequest[servicerequestId=%s, serviceRequestCustomerId='%s', serviceRequestSeverity='%s', serviceRequestAssignedTo='%s, serviceRequestRaisedOn='%s, serviceRequestClosedOn='%s'']", this.serviceRequestId,
				this.serviceRequestCustomerId, this.serviceRequestSeverity, this.serviceRequestAssignedTo, this.serviceRequestRaisedOn, this.serviceRequestClosedOn);
	}
}