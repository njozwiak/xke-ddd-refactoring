package com.xebia.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.xebia.repository.EcheanceRequestRepository;
import com.xebia.repository.ProductRepository;
import com.xebia.service.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceModule extends AbstractModule {

    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void configure() {
        entityManagerFactory = Persistence.createEntityManagerFactory("dddDB");

        bind(EcheanceRequestRepository.class);
        bind(ProductRepository.class);

        bind(ProductService.class);
    }

    @Provides
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
