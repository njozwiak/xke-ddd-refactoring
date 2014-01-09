package com.xebia.domain.comission;

import com.google.inject.Inject;
import com.xebia.domain.comission.Comission;

import javax.persistence.EntityManager;

public class ComissionRepository {

    private EntityManager entityManager;

    @Inject
    public ComissionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Comission comission) {
        entityManager.getTransaction().begin();
        entityManager.merge(comission);
        entityManager.getTransaction().commit();
    }

    public Comission findOne(Long id) {
        try {
            return entityManager.find(Comission.class, id);
        } finally {
            entityManager.close();
        }
    }

}
