package com.apimsa.labs.servicerequest.domain.model;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="servicerequest")
public class ServiceRequest {
	
	// by default mongo documents have a _id
	@Id
	public ObjectId _id;
	
	@Indexed(unique = true)
	private String serviceRequestId;
	
	private String serviceRequestCustomerId;
	private String serviceRequestSeverity;
	private String serviceRequestAssignedTo;
	private String serviceRequestRaisedOn;
	private String serviceRequestClosedOn;
		

	
	
	public ServiceRequest(ObjectId _id, String serviceRequestId, String serviceRequestCustomerId, String serviceRequestSeverity,
			String serviceRequestAssignedTo, String serviceRequestRaisedOn, String serviceRequestClosedOn) {
		super();
		this._id = _id;
		this.serviceRequestId = serviceRequestId;
		this.serviceRequestCustomerId = serviceRequestCustomerId;
		this.serviceRequestSeverity = serviceRequestSeverity;
		this.serviceRequestAssignedTo = serviceRequestAssignedTo;
		this.serviceRequestRaisedOn = serviceRequestRaisedOn;
		this.serviceRequestClosedOn = serviceRequestClosedOn;
	}


	// ObjectId needs to be converted to string
	public String get_id() { return _id.toHexString(); }
	  
	public void set_id(ObjectId _id) { this._id = _id; }


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