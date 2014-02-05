package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.commission.Commission;
import com.xebia.domain.commission.Montant;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.ProductDecimal;
import com.xebia.domain.product.Product;
import com.xebia.domain.commission.CommissionRepository;
import com.xebia.domain.product.ProductRepository;
import com.xebia.module.PersistenceModule;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AbstractIntegrationTest {

    @Inject
    private CommissionRepository commissionRepository;

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

        commissionRepository.save(createComission(1L, new Date(), new Date(), BigDecimal.TEN, product));
    }

    private Commission createComission(Long id, Date dateDebut, Date dateFin, BigDecimal montant, Product product) {
        Commission commission = new Commission();

        commission.setId(id);
        commission.setDateDebut(dateDebut);
        commission.setDateFin(dateFin);
        commission.setMontant(new Montant(new ProductDecimal(montant), new Currency()));
        commission.setProduct(product);

        return commission;
    }

    private Product createProduct(Long id, String name) {
        Product product = new Product();

        product.setId(id);
        product.setName(name);

        return product;
    }

}
