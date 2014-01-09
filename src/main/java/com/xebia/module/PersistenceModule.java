package com.xebia.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.xebia.domain.comission.ComissionRepository;
import com.xebia.repository.DeviseRepository;
import com.xebia.domain.echeance.EcheanceRequestRepository;
import com.xebia.domain.product.ProductRepository;
import com.xebia.domain.product.ProductService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceModule extends AbstractModule {

    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void configure() {
        entityManagerFactory = Persistence.createEntityManagerFactory("dddDB");

        bind(ComissionRepository.class);
        bind(DeviseRepository.class);
        bind(EcheanceRequestRepository.class);
        bind(ProductRepository.class);

        bind(ProductService.class);
    }

    @Provides
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
