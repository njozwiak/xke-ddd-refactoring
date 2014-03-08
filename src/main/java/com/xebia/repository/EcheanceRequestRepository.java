package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.domain.EcheanceRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class EcheanceRequestRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(EcheanceRequestRepository.class);

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public EcheanceRequestRepository(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public EcheanceRequest findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(EcheanceRequest.class, id);
        } finally {
            entityManager.close();
        }
    }

    public void save(EcheanceRequest echeanceRequest) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(echeanceRequest);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();

            LOGGER.error("Unable to save echeance: %s", e.getCause());
        } finally {
            entityManager.close();
        }
    }
}
