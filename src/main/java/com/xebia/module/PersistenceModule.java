package com.xebia.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.xebia.domain.commission.CommissionRepository;
import com.xebia.domain.product.ProductRepository;
import com.xebia.domain.product.ProductService;
import com.xebia.repository.CommissionRepositoryImpl;
import com.xebia.repository.ProductRepositoryImpl;
import com.xebia.service.ProductServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceModule extends AbstractModule {

    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void configure() {
        entityManagerFactory = Persistence.createEntityManagerFactory("dddDB");

        //TODO
        bind(CommissionRepository.class).to(CommissionRepositoryImpl.class);
        bind(ProductRepository.class).to(ProductRepositoryImpl.class);

        bind(ProductService.class).to(ProductServiceImpl.class);
    }

    @Provides
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
