package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.Comission;
import com.xebia.domain.Product;
import com.xebia.module.PersistenceModule;
import com.xebia.repository.ComissionRepository;
import com.xebia.repository.ProductRepository;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AbstractIntegrationTest {

    @Inject
    private ComissionRepository comissionRepository;

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
        Product product = productRepository.findOne(1L);

        comissionRepository.save(createComission(1L, new Date(), new Date(), BigDecimal.TEN, product));
    }

    private Comission createComission(Long id, Date dateDebut, Date dateFin, BigDecimal montant, Product product) {
        Comission comission = new Comission();

        comission.setId(id);
        comission.setDateDebut(dateDebut);
        comission.setDateFin(dateFin);
        comission.setMontant(montant);
        comission.setProduct(product);

        return comission;
    }

    private Product createProduct(Long id, String name) {
        Product product = new Product();

        product.setId(id);
        product.setName(name);

        return product;
    }

}
