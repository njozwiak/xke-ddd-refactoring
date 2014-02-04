package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.domain.Comission;

import javax.inject.Provider;
import javax.persistence.EntityManager;

// TODO move to another package and create interface

public class ComissionRepository {

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public ComissionRepository(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    public void save(Comission comission) {
        EntityManager entityManager = entityManagerProvider.get();

        entityManager.getTransaction().begin();
        entityManager.merge(comission);
        entityManager.getTransaction().commit();
    }

    public Comission findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(Comission.class, id);
        }
        finally {
            entityManager.close();
        }
    }

}
