package com.xebia.infrastructure.persistence;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.echeance.ProductDecimal;
import com.xebia.domain.comission.Comission;
import com.xebia.domain.comission.ComissionRepository;
import org.junit.Test;

import java.math.BigDecimal;

import static org.fest.assertions.Assertions.assertThat;

public class HibernateComissionRepositoryTest extends AbstractIntegrationTest {

    @Inject
    private ComissionRepository comissionRepository;

    @Test
    public void should_find_comission_by_id() {
        // Given
        // When
        Comission result = comissionRepository.findOne(1L);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getMontant().getValue().compareTo(new ProductDecimal(BigDecimal.TEN))).isEqualTo(0);
    }
}
