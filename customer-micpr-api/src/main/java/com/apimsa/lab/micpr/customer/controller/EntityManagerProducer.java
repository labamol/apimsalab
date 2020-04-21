package com.apimsa.lab.micpr.customer.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

// This class is needed if using @Inject to instantiate Entity manager and not needed if using @PersistenceContext

@ApplicationScoped
public class EntityManagerProducer {

    @Produces
    public EntityManager createEntityManager() {
        return Persistence
                .createEntityManagerFactory("customerapi-unit")
                .createEntityManager();
    }

    public void close(EntityManager entityManager) {
        entityManager.close();
    }

}
