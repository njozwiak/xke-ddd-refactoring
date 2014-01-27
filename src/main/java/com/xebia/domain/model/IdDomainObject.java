package com.xebia.domain.model;

import java.io.Serializable;

public class IdDomainObject implements Serializable {

  private long id;

  protected IdDomainObject() {
    super();

    this.setId(-1);
  }

  protected long id() {
    return this.id;
  }

  private void setId(long anId) {
    this.id = anId;
  }

}
