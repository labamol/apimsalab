package com.apimsa.labs.account.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apimsa.labs.account.domain.model.Account;


/**
public interface CustomerRepository extends CrudRepository<Customer, int> {
	
	@Query(value="SELECT * FROM customer WHERE customerPhone=?0")
	public List<Customer> findByCustomerPhone(String customerPhone);
 
	@Query(value="SELECT * FROM customer WHERE customerId=?0")
	public List<Customer> findByCustomerId(int customerId);	
}	

**/

public interface AccountRepository extends MongoRepository<Account, String> {
	 
	@Query("{accountId: '?0'}")
	public List<Account> findByAccountId(String accountId);
 
	@Query("{customerId: '?0'}")
	public List<Account> findByCustomerId(String customerId);
	
	
}

