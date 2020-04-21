package com.apimsa.labs.account.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.apimsa.labs.account.domain.model.Account;
import com.apimsa.labs.account.repo.AccountRepository;

@Service
//@EnableMongoRepositories("com.apimsa.labs.account.repo")
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public List<Account> findByAccountId(String accountId) {		
		return accountRepository.findByAccountId(accountId); 
	}

	@Override
	public List<Account> findByCustomerId(String customerId) {
		return accountRepository.findByCustomerId(customerId);
	}
	
	@Override
	public String createAccount(Account account) {
		accountRepository.save(account);
		return "Account Added";
	}
	
	@Override
	public String activateAccount(String accountId) {
//		Query query = new Query();
//	    query.addCriteria(Criteria.where("accountId").is(account.getAccountId()));
//	    Update update = new Update();
//	    update.set("accountStatus", account.getAccountStatus());
//	    return new MongoTemplate().findAndModify(query, update, Account.class);
		
		if (accountRepository.findByAccountId(accountId).size()>0) {
			Account account = accountRepository.findByAccountId(accountId).get(0);
			account.setAccountStatus("A");
			accountRepository.save(account);
			return "Account Activated";
		} else {
			return "Account Not Found";
		}
		

	}
	
	

}
