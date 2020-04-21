package com.apimsa.lab.micpr.customer.domain.model;

import java.io.Serializable;

//import org.bson.types.ObjectId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	 
	// by default mongo documents have a _id
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Object id;
	// OR use below ..
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")
    private String id;
	
	
	private String customerId;
	
	private String customerName;
	private String customerPhone;
	private String customerType;
	private String customerSubType;
		
	public Customer(){}
	
	public Customer(String customerId, String customerName, String customerPhone, String customerType,
			String customerSubType) {
		super();

		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerType = customerType;
		this.customerSubType = customerSubType;
	}
	
	/**	public Customer(Object _id, String customerId, String customerName, String customerPhone, String customerType,
			String customerSubType) {
		super();
		this._id = _id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerType = customerType;
		this.customerSubType = customerSubType;
	}


	public Object get_id() {
		return _id;
	}


	public void set_id(Object _id) {
		this._id = _id;
	}
	*/

	public String getCustomerId() {
		return customerId;
	}




	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}




	public String getCustomerName() {
		return customerName;
	}




	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}




	public String getCustomerPhone() {
		return customerPhone;
	}




	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}




	public String getCustomerType() {
		return customerType;
	}




	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}




	public String getCustomerSubType() {
		return customerSubType;
	}




	public void setCustomerSubType(String customerSubType) {
		this.customerSubType = customerSubType;
	}




	@Override
	public String toString() {
		return String.format("Customer[customerId=%s, customerName='%s', customerPhone='%s', customerType='%s, customerSubType='%s'']", this.customerId,
				this.customerName, this.customerPhone, this.customerType, this.customerSubType);
	}
}