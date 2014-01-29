package com.xebia.infrastructure.persistence;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.xebia.domain.product.Product;
import com.xebia.domain.product.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateProductRepository implements ProductRepository {

    private final Logger LOGGER = LoggerFactory.getLogger(HibernateProductRepository.class);

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public HibernateProductRepository(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public List<Product> findAll() {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.createQuery("from Product").getResultList();
        }
        finally {
            entityManager.close();
        }
    }

    public Product findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(Product.class, id);
        }
        finally {
            entityManager.close();
        }
    }

    public void save(Product product) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(product);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();

            LOGGER.error("Unable to save product: {}", e.getCause());
        }
        finally {
            entityManager.close();
        }
    }

}
