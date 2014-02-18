package com.xebia.domain.product;

import com.google.common.base.Objects;

import com.xebia.model.Identity;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;

public final class ProductId extends Identity {

  private String referenceCode;

  public ProductId(String id, String referenceCode) {
    super(id);
    this.referenceCode = referenceCode;
  }

  protected ProductId() {
    super();
  }

  public String getReferenceCode() {
    return referenceCode;
  }

  private void setReferenceCode(String referenceCode) {
    checkArgument(isNullOrEmpty(referenceCode), "Reference code cannot be null or empty");

    this.referenceCode = referenceCode;
  }

  @Override
  protected void validateId(String id) {
    try {
      UUID.fromString(id);
    } catch (Exception e) {
      throw new IllegalArgumentException("The id has an invalid format.");
    }
  }

  @Override
  public boolean equals(Object object) {
    boolean equalObjects = false;

    if (object != null && this.getClass() == object.getClass()) {
      ProductId typedObject = (ProductId) object;
      equalObjects = this.referenceCode.equals(typedObject.referenceCode);
    }

    return equalObjects;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(referenceCode);
  }

}
