package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.comission.Montant;
import com.xebia.domain.echeance.ProductDecimal;
import com.xebia.domain.comission.Comission;
import com.xebia.domain.comission.ComissionRepository;
import com.xebia.domain.currency.Currency;
import com.xebia.module.PersistenceModule;
import org.junit.Before;

import java.util.Date;

public abstract class AbstractIntegrationTest {

    @Inject
    private ComissionRepository comissionRepository;

    @Before
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new PersistenceModule());

        injector.injectMembers(this);

        initDatabase();
    }

    private void initDatabase() {
        comissionRepository.save(createComission(new Date(), new Date(), new Montant(ProductDecimal.TEN, new Currency("EURO", Currency.EUR_ISO))));
        comissionRepository.save(createComission(new Date(), new Date(), new Montant(ProductDecimal.TEN, new Currency("EURO", Currency.EUR_ISO))));
    }

    private Comission createComission(Date dateDebut, Date dateFin, Montant montant) {
        return new Comission(dateDebut, dateFin, montant);
    }

}
