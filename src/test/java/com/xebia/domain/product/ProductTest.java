package com.xebia.domain.product;

import com.xebia.domain.echeance.EcheanceRequest;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class ProductTest {

    @Test
    public void should_get_active_echeances() {
        //GIVEN
        EcheanceRequest echeanceRequest1 = new EcheanceRequest();
        echeanceRequest1.setId(1L);
        echeanceRequest1.setActive(true);

        EcheanceRequest echeanceRequest2 = new EcheanceRequest();
        echeanceRequest2.setId(2L);
        echeanceRequest2.setActive(false);

        Product product = new Product();
        product.addEcheance(echeanceRequest1);
        product.addEcheance(echeanceRequest2);

        //WHEN
        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestActive();

        //THEN
        assertThat(echeanceRequestActive).hasSize(1);
        assertThat(echeanceRequestActive).onProperty("id").containsOnly(1L);

    }
}
