package com.xebia.domain.product;

import com.xebia.domain.model.Identity;

public final class ProductId extends Identity {

    private String referenceCode;

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }
}
