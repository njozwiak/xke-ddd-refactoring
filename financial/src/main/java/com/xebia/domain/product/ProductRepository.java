package com.xebia.domain.product;

import java.util.List;

public interface ProductRepository {

  public List<Product> findAll();

  public Product findOne(Long id);

  public void save(Product product);

}
