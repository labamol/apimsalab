package com.apimsa.labs.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimsa.labs.account.domain.model.Account;
import com.apimsa.labs.account.domain.service.AccountService;




@RestController
//set baseUrl of API to /account
@RequestMapping("/account")
public class AccountController {

	@Autowired
    private AccountService service;

    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET, produces = "application/json")
    public List<Account> findByAccountId(@PathVariable(value="accountId") String accountId) {
      return service.findByAccountId(accountId);
    } 

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET, produces = "application/json")
    public List<Account> findByCustomerPhone(@PathVariable(value="customerId") String customerId) {
      return service.findByCustomerId(customerId);
    } 
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public String addAccount(@RequestBody Account account) {
      return service.createAccount(account);
    }
    
    @RequestMapping(value = "/activate/{accountId}", method = RequestMethod.POST, produces = "application/json")
    public String activateAccount(@PathVariable(value="accountId") String accountId) {
      return service.activateAccount(accountId);
    } 
	
}
