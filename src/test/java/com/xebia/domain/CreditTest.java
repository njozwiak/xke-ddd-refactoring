package com.xebia.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class CreditTest {

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

        Credit credit = new Credit();
        credit.setEcheanceRequests(echeances);

        //WHEN
        List<EcheanceRequest> echeanceRequestActive = credit.getEcheanceRequestActive();

        //THEN
        assertThat(echeanceRequestActive).hasSize(1);
        assertThat(extractProperty("id").from(echeanceRequestActive)).containsOnly(1L);
    }

}
