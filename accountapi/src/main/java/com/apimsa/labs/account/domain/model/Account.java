package com.apimsa.labs.account.domain.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="account")
public class Account {
	
	// by default mongo documents have a _id
	@Id
	public ObjectId _id;
	
	@Indexed(unique = true)
	private String accountId;
	
	private String customerId;
	private String accountPhone;
	private String accountType;
	private String accountStatus;
	
	public Account() {}
	

	public Account(ObjectId _id, String accountId, String customerId, String accountPhone, String accountType,
			String accountStatus) {
		super();
		this._id = _id;
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountPhone = accountPhone;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}



	public Account(String accountId, String customerId, String accountPhone, String accountType, String accountStatus) {
		super();
		this.accountId = accountId;
		this.customerId = customerId;
		this.accountPhone = accountPhone;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
	}


	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountPhone() {
		return accountPhone;
	}

	public void setAccountPhone(String accountPhone) {
		this.accountPhone = accountPhone;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
		



	@Override
	public String toString() {
		return String.format("Account[accountId=%s, customerId='%s', accountPhone='%s', accountType='%s', accountStatus='%s']", this.accountId,
				this.customerId, this.accountPhone, this.accountType, this.accountStatus);
	
	}
	
	
}