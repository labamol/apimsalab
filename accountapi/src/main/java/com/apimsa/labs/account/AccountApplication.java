package com.apimsa.labs.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apimsa.labs.account.domain.model.Account;
import com.apimsa.labs.account.repo.AccountRepository;

@SpringBootApplication
//@EnableMongoRepositories("com.apimsa.labs.account.repo")
public class AccountApplication {

	@Autowired
    AccountRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	
	}

		
	}
