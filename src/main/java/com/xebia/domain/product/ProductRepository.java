package com.xebia.domain.product;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class ProductRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRepository.class);

    private EntityManager entityManager;

    @Inject
    public ProductRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Product findOne(Long id) {
        try {
            return entityManager.find(Product.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void save(Product product) {
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
