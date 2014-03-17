package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.Credit;
import com.xebia.domain.EcheanceRequest;
import com.xebia.module.PersistenceModule;
import com.xebia.repository.EcheanceRequestRepository;
import com.xebia.repository.CreditRepository;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Date;

public abstract class AbstractIntegrationTest {

    @Inject
    private CreditRepository creditRepository;

    @Inject
    private EcheanceRequestRepository echeanceRequestRepository;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new PersistenceModule());

        injector.injectMembers(this);

        initDatabase();
    }

    private void initDatabase() {
        creditRepository.save(createProduct(1L, "produit_1"));
        Credit credit = creditRepository.findOne(1L);

        echeanceRequestRepository.save(createEcheance(1L, BigDecimal.TEN, new Date(), credit));

    }

    private Credit createProduct(Long id, String name) {
        Credit credit = new Credit();

        credit.setId(id);
        credit.setName(name);

        return credit;
    }

    private EcheanceRequest createEcheance(Long id, BigDecimal crd, Date date, Credit credit) {
        EcheanceRequest echeanceRequest = new EcheanceRequest();

        echeanceRequest.setId(id);
        echeanceRequest.setCrd(crd);
        echeanceRequest.setPaymentDate(date);
        echeanceRequest.setCredit(credit);

        return echeanceRequest;
    }

}
