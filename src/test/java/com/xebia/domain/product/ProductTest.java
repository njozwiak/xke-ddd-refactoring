package com.xebia.domain.product;

import com.xebia.domain.echeance.EcheanceRequest;
import com.xebia.domain.echeance.EcheanceRequestBuilder;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class ProductTest {

    @Test
    public void should_get_active_echeances() {
        //GIVEN
        EcheanceRequest echeanceRequest1 = new EcheanceRequestBuilder().build();
        EcheanceRequest echeanceRequest2 = new EcheanceRequestBuilder().inactive().build();

        Product product = new Product();
        product.addEcheance(echeanceRequest1);
        product.addEcheance(echeanceRequest2);

        //WHEN
        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestActive();

        //THEN
        assertThat(echeanceRequestActive).hasSize(1);

    }
}
