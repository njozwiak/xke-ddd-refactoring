package com.xebia;

import com.google.common.collect.Lists;
import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class ProductTest {

    @Test
    public void should_get_active_echeances() {
        //GIVEN
        ArrayList<EcheanceRequest> echeances = Lists.newArrayList();

        EcheanceRequest echeanceRequest1 = new EcheanceRequest();
        echeanceRequest1.setId(1L);
        echeanceRequest1.setActive(true);

        EcheanceRequest echeanceRequest2 = new EcheanceRequest();
        echeanceRequest2.setId(2L);
        echeanceRequest2.setActive(false);

        echeances.add(echeanceRequest1);
        echeances.add(echeanceRequest2);

        Product product = new Product();
        product.setEcheanceRequests(echeances);

        //WHEN
        List<EcheanceRequest> echeanceRequestActive = product.getEcheanceRequestActive();

        //THEN
        assertThat(echeanceRequestActive).hasSize(1);
        assertThat(echeanceRequestActive).onProperty("id").containsOnly(1L);

    }
}
