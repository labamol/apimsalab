package com.apimsa.lab.micpr.customer.domain.service;

import java.util.ArrayList;
import java.util.List;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.apimsa.lab.micpr.customer.domain.model.Customer;

@ApplicationScoped

public class CustomerServiceImpl implements CustomerService {

	   @Inject
	    //@PersistenceContext(unitName = "customerapi-unit")
	    private EntityManager em;
	  
	 
	   public List<Customer> getAll() {
	        List<Customer> customers = em.createNamedQuery("Customer.findAll", Customer.class).getResultList();
	        return customers != null ? customers : new ArrayList();
	    }


	    public Customer findById(String id) {
	    	
	        return em.find(Customer.class, id);
	    }
	   
	   
	    public void update(Customer customer) {
	        em.getTransaction().begin();
	        em.merge(customer);
	        em.getTransaction().commit();
	    }
	    
	    //or use
	    //@Transactional
	    //public void update(Customer customer) {
	    //    em.merge(customer);
	   // }

//	    public void create(Customer customer) {
//	        em.getTransaction().begin();
//	        em.persist(customer);
//	        em.getTransaction().commit();
//	    }

	    @Transactional
	    public void create(Customer customer) {
	        em.persist(customer);
	    }
	    	
	    @Transactional
	    public void delete(Customer customer) {
	    if (!em.contains(customer)) {
	    customer = em.merge(customer);
	    }
	    em.remove(customer);
	    }
	

}
