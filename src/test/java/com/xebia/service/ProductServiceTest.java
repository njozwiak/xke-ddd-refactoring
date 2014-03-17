package com.xebia.service;

import com.google.common.collect.Lists;
import com.xebia.domain.Credit;
import com.xebia.domain.Currency;
import com.xebia.domain.EcheanceRequest;
import com.xebia.repository.CreditRepository;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private CreditService creditService;

    @Mock
    private DataService dataService;

    @Mock
    private CreditRepository creditRepository;

    @Before
    public void init() throws Exception {
        creditService = new CreditService(dataService, creditRepository);
    }

    @Test
    public void should_be_true_when_contains_funding_currencies() {
        Currency euro = new Currency(1L, "EURO", Currency.EUR_ISO);
        Currency us = new Currency(2L, "US", Currency.USD_ISO);

        Boolean result = creditService.containsFundingCurrencies(Lists.newArrayList(euro, us));

        assertThat(result).isTrue();
    }

    @Test
    public void should_be_false_when_no_contains_funding_currencies() {
        Currency gpb = new Currency(1L, "GPB", "GPB");

        Boolean result = creditService.containsFundingCurrencies(Lists.newArrayList(gpb));

        assertThat(result).isFalse();
    }

    @Test
    public void should_add_echeance_to_product() {
        // Given
        Credit credit = new Credit();
        credit.setEcheanceRequests(Lists.<EcheanceRequest>newArrayList());

        EcheanceRequest echeance = new EcheanceRequest();
        echeance.setActive(true);

        long productId = 1L;
        when(creditRepository.findOne(productId)).thenReturn(credit);

        // When
        creditService.addEcheanceToProduct(productId, echeance);
        // Then

        assertThat(credit.getEcheanceRequestActive()).hasSize(1).contains(echeance);
    }

    // TODO: gestion du NPE sur la multiplication du crd
    @Test
    public void should_not_valorise_echeance_with_null_crd() {
        // Given
        EcheanceRequest echeanceRequest = new EcheanceRequest();
        echeanceRequest.setActive(true);
        echeanceRequest.setPaymentDate(new DateTime(2014, 2, 28, 0, 0).toDate());

        Credit credit = new Credit();
        credit.getEcheanceRequests().add(echeanceRequest);

        // When
        when(dataService.getCrossChange(Matchers.<Date>any())).thenReturn(BigDecimal.TEN);

        List<EcheanceRequest> valoriseEcheanceRequests = creditService.valoriseProduct(credit, new DateTime(2014, 2, 3, 0, 0).toDate());

        // Then
        assertThat(valoriseEcheanceRequests).hasSize(1);
        assertThat(extractProperty("crd").from(valoriseEcheanceRequests)).containsNull();
    }

}
