package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.product.ProductRepository;
import org.junit.Test;

public class ProductRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private ProductRepository productRepository;

    @Test
    public void testFindOne() throws Exception {

    }
}
