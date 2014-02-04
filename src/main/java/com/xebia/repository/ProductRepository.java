package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import javax.persistence.EntityManager;

// TODO move to another package and create interface

public class ProductRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public ProductRepository(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public Product findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(Product.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void save(Product product) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();

            LOGGER.error("Unable to save product: %s", e.getCause());
        } finally {
            entityManager.close();
        }
    }

}
