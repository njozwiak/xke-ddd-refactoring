package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.domain.commission.Commission;
import com.xebia.domain.commission.CommissionRepository;

import javax.inject.Provider;
import javax.persistence.EntityManager;

public class CommissionRepositoryImpl implements CommissionRepository {

    private Provider<EntityManager> entityManagerProvider;

    @Inject
    public CommissionRepositoryImpl(Provider<EntityManager> entityManagerProvider) {
        this.entityManagerProvider = entityManagerProvider;
    }

    @Override
    public void save(Commission commission) {
        EntityManager entityManager = entityManagerProvider.get();

        entityManager.getTransaction().begin();
        entityManager.merge(commission);
        entityManager.getTransaction().commit();
    }

    @Override
    public Commission findOne(Long id) {
        EntityManager entityManager = entityManagerProvider.get();

        try {
            return entityManager.find(Commission.class, id);
        }
        finally {
            entityManager.close();
        }
    }

}
