package com.xebia.domain.comission;

public interface ComissionRepository {

  public void save(Comission comission);

  public Comission findOne(Long id);

}
