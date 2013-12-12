package com.xebia.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

public class ProductDecimal implements Serializable {

    public static final ProductDecimal ZERO = new ProductDecimal(BigDecimal.ZERO);
    public static final ProductDecimal ONE = new ProductDecimal(BigDecimal.ONE);
    public static final ProductDecimal TEN = new ProductDecimal(BigDecimal.TEN);

    private BigDecimal value;

    public ProductDecimal(BigDecimal value) {
        this.value = value;
    }

    public ProductDecimal add(ProductDecimal number) {
        if (number != null) {
            return new ProductDecimal(this.getValue().add(number.getValue(), MathContext.DECIMAL64));
        }
        return ProductDecimal.ZERO;
    }

    public ProductDecimal substract(ProductDecimal number) {
        if (number != null) {
            return new ProductDecimal(this.getValue().subtract(number.getValue(), MathContext.DECIMAL64));
        }
        return ProductDecimal.ZERO;
    }

    public ProductDecimal multiply(ProductDecimal number) {
        if (number != null) {
            return new ProductDecimal(this.getValue().multiply(number.getValue(), MathContext.DECIMAL64));
        }
        return ProductDecimal.ZERO;
    }

    public ProductDecimal divide(ProductDecimal number) {
        if (number != null || this.compareTo(number) != 0) {
            return new ProductDecimal(this.getValue().divide(number.getValue(), MathContext.DECIMAL64));
        }
        return ProductDecimal.ZERO;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int compareTo(ProductDecimal number) {
        if (number != null) {
            return this.getValue().compareTo(number.getValue());
        }
        return -1;
    }
}
