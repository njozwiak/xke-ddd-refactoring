package com.xebia;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.xebia.domain.comission.Comission;
import com.xebia.module.PersistenceModule;
import com.xebia.domain.comission.ComissionRepository;
import org.junit.Before;

import java.math.BigDecimal;
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
        comissionRepository.save(createComission(1L, new Date(), new Date(), BigDecimal.TEN));
        comissionRepository.save(createComission(null, new Date(), new Date(), BigDecimal.TEN));
    }

    private Comission createComission(Long id, Date dateDebut, Date dateFin, BigDecimal montant) {
        Comission comission = new Comission();

        comission.setId(id);
        comission.setDateDebut(dateDebut);
        comission.setDateFin(dateFin);
        comission.setMontant(montant);

        return comission;
    }

}
