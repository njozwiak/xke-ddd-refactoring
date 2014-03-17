package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.domain.Credit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class CreditRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditRepository.class);

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public CreditRepository(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public Credit findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(Credit.class, id);
        }
        finally {
            entityManager.close();
        }
    }

    public void save(Credit credit) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(credit);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            entityManager.getTransaction().rollback();

            LOGGER.error("Unable to save credit: %s", e.getCause());
        }
        finally {
            entityManager.close();
        }
    }

}
