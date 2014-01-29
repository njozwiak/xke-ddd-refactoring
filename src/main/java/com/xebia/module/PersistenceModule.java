package com.xebia.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.xebia.application.ProductApplicationService;
import com.xebia.domain.comission.ComissionRepository;
import com.xebia.domain.product.ProductRepository;
import com.xebia.infrastructure.persistence.HibernateComissionRepository;
import com.xebia.infrastructure.persistence.HibernateProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceModule extends AbstractModule {

    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void configure() {
        entityManagerFactory = Persistence.createEntityManagerFactory("dddDB");

        bind(ComissionRepository.class).to(HibernateComissionRepository.class);
        bind(ProductRepository.class).to(HibernateProductRepository.class);

        bind(ProductApplicationService.class);
    }

    @Provides
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
