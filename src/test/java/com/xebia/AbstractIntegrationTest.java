package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.Product;
import com.xebia.module.PersistenceModule;
import com.xebia.repository.ProductRepository;
import org.junit.Before;

public abstract class AbstractIntegrationTest {

    @Inject
    private ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new PersistenceModule());

        injector.injectMembers(this);

        initDatabase();
    }

    private void initDatabase() {
        productRepository.save(createProduct(1L, "produit_1"));
    }

    private Product createProduct(Long id, String name) {
        Product product = new Product();

        product.setId(id);
        product.setName(name);

        return product;
    }

}
