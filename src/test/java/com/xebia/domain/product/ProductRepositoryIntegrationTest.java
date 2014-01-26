package com.xebia.domain.product;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.product.ProductRepository;
import org.fest.assertions.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class ProductRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private ProductRepository productRepository;

    @Test
    public void testFindOne() {

    }

    @Test
    public void should_save_product() {
        // Given
        EcheanceRequest echeanceRequest = new EcheanceRequest();
        echeanceRequest.setActive(true);
        echeanceRequest.setBeginDate(new Date());
        echeanceRequest.setEndDate(new Date());
        echeanceRequest.setReoffer(BigDecimal.TEN);

        Product product = new Product();
        product.setName("Save product test");
        product.setMarketDate(new Date());
        product.addEcheance(echeanceRequest);

        // When
        productRepository.save(product);

        // Then
        assertThat(productRepository.findAll()).isNotEmpty();
    }

}
