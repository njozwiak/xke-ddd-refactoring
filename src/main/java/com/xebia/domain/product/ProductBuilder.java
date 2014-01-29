package com.xebia.domain.product;

import java.util.Date;

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

    public ProductBuilder withMarketDate(Date marketDate) {
      product.setMarketDate(marketDate);
      return this;
    }
}
