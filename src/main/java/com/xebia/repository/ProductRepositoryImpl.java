package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.domain.product.Product;
import com.xebia.domain.product.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class ProductRepositoryImpl implements ProductRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepositoryImpl.class);

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public ProductRepositoryImpl(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public Product findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(Product.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
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
