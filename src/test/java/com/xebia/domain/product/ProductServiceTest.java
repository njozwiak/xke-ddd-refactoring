package com.xebia.domain.product;

import com.google.common.collect.Lists;
import com.xebia.domain.ProductDecimal;
import com.xebia.domain.currency.Currency;
import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.port.adapter.service.ProductDataService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;

public class ProductServiceTest {

    private ProductService productService;

    @Mock
    private ProductDataService dataService;

    @Before
    public void init() throws Exception {
        productService = new ProductService(dataService);
    }

    @Test
    public void should_be_true_when_contains_funding_currencies() {
        Currency euro = new Currency("EURO", Currency.EUR_ISO);
        Currency us = new Currency("US", Currency.USD_ISO);

        Boolean result = productService.containsFundingCurrencies(Lists.newArrayList(euro, us));

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_false_when_no_contains_funding_currencies() {
        Currency gpb = new Currency("GPB", "GPB");

        Boolean result = productService.containsFundingCurrencies(Lists.newArrayList(gpb));

        assertThat(result).isFalse();
    }

    @Test
    public void should_return_remaining_echeance_after_date() {
        // Given
        Product product = new Product();

        product.addEcheance(new EcheanceRequest(new DateTime(2014, 5, 1, 0, 0).toDate(), new DateTime(2014, 5, 31, 0, 0).toDate(), new ProductDecimal(new BigDecimal("1500")), BigDecimal.ZERO, true));
        product.addEcheance(new EcheanceRequest(new DateTime(2014, 6, 1, 0, 0).toDate(), new DateTime(2014, 6, 30, 0, 0).toDate(), new ProductDecimal(new BigDecimal("1000")), BigDecimal.ZERO, true));
        product.addEcheance(new EcheanceRequest(new DateTime(2014, 7, 1, 0, 0).toDate(), new DateTime(2014, 7, 31, 0, 0).toDate(), new ProductDecimal(new BigDecimal("500")), BigDecimal.ZERO, true));
        product.addEcheance(new EcheanceRequest(new DateTime(2014, 8, 1, 0, 0).toDate(), new DateTime(2014, 8, 31, 0, 0).toDate(), new ProductDecimal(new BigDecimal("0")), BigDecimal.ZERO, true));

        // When
        Integer result = productService.countRemainingEcheanceAfter(product, new DateTime(2014, 6, 2, 0, 0).toDate());

        // Then
        assertThat(result).isEqualTo(2);
    }

}
