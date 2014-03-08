package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.EcheanceRequest;
import com.xebia.domain.Product;
import com.xebia.module.PersistenceModule;
import com.xebia.repository.EcheanceRequestRepository;
import com.xebia.repository.ProductRepository;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AbstractIntegrationTest {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private EcheanceRequestRepository echeanceRequestRepository;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new PersistenceModule());

        injector.injectMembers(this);

        initDatabase();
    }

    private void initDatabase() {
        productRepository.save(createProduct(1L, "produit_1"));
        Product product = productRepository.findOne(1L);

        echeanceRequestRepository.save(createEcheance(1L, BigDecimal.TEN, new Date(), product));

    }

    private Product createProduct(Long id, String name) {
        Product product = new Product();

        product.setId(id);
        product.setName(name);

        return product;
    }

    private EcheanceRequest createEcheance(Long id, BigDecimal crd, Date date, Product product) {
        EcheanceRequest echeanceRequest = new EcheanceRequest();

        echeanceRequest.setId(id);
        echeanceRequest.setCrd(crd);
        echeanceRequest.setPaymentDate(date);
        echeanceRequest.setProduct(product);

        return echeanceRequest;
    }

}
