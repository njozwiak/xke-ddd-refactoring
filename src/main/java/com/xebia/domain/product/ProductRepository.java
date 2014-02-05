package com.xebia.domain.product;

import com.xebia.domain.product.Product;

public interface ProductRepository {
    Product findOne(Long id);

    void save(Product product);
}
