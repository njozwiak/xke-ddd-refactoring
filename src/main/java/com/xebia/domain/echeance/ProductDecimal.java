package com.xebia.domain.echeance;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductDecimal implements Serializable {

    private final BigDecimal decimal;


    public ProductDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    public BigDecimal decimal() {
        return decimal;
    }

    public ProductDecimal add(ProductDecimal productDecimal) {
        return new ProductDecimal(decimal.add(productDecimal.decimal));
    }

    public BigDecimal multiply(BigDecimal fixingPourDate) {

        return null;
    }
}
