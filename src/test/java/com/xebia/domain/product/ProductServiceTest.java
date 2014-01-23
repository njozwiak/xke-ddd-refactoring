package com.xebia.domain.product;

import com.google.common.collect.Lists;
import com.xebia.domain.currency.Currency;
import com.xebia.port.adapter.service.ProductDataService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
        Currency euro = new Currency(1L, "EURO", Currency.EUR_ISO);
        Currency us = new Currency(2L, "US", Currency.USD_ISO);

        Boolean result = productService.containsFundingCurrencies(Lists.newArrayList(euro, us));

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_false_when_no_contains_funding_currencies() {
        Currency gpb = new Currency(1L, "GPB", "GPB");

        Boolean result = productService.containsFundingCurrencies(Lists.newArrayList(gpb));

        assertThat(result).isFalse();
    }
}
