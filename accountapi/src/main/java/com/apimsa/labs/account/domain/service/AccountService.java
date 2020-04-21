package com.apimsa.labs.account.domain.service;

import java.util.List;

import com.apimsa.labs.account.domain.model.Account;

public interface AccountService {
	
	public List<Account> findByAccountId(String accountId);
	public List<Account> findByCustomerId(String customerId);
	public String createAccount(Account account);
	public String activateAccount(String accountId);	

}
