package com.xebia.domain.builder;

import com.xebia.domain.Product;

public class ProductBuilder {

    private Product product;

    public ProductBuilder() {
        this.product = new Product();
    }

    public Product build() {
        return product;
    }

    public ProductBuilder withName(String name) {
        product.setName(name);
        return this;
    }
}
