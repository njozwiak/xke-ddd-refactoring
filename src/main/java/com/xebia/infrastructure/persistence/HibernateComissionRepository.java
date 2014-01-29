package com.xebia.infrastructure.persistence;

import com.google.inject.Inject;

import com.xebia.domain.comission.Comission;
import com.xebia.domain.comission.ComissionRepository;

import javax.persistence.EntityManager;

public class HibernateComissionRepository implements ComissionRepository {

  private EntityManager entityManager;

  @Inject
  public HibernateComissionRepository(EntityManager entityManager) {
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
