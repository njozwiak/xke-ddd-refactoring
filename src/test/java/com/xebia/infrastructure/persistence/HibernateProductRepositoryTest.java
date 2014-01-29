package com.xebia.infrastructure.persistence;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBuilder;
import com.xebia.domain.product.Product;
import com.xebia.domain.product.ProductBuilder;
import com.xebia.domain.product.ProductRepository;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.fest.assertions.Assertions.assertThat;

public class HibernateProductRepositoryTest extends AbstractIntegrationTest {

    @Inject
    private ProductRepository productRepository;

    @Test
    public void testFindOne() {

    }

    @Test
    public void should_save_product() {
        // Given
        EcheanceRequest echeanceRequest = new EcheanceRequestBuilder().withPaymentDate(new Date())
                .withReoffer(BigDecimal.TEN)
                .build();
        Product product = new ProductBuilder().withName("Save product test").withMarketDate(new Date()).build();
        product.addEcheance(echeanceRequest);

        // When
        productRepository.save(product);

        // Then
        assertThat(productRepository.findAll()).isNotEmpty();
    }
}
