package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.commission.Commission;
import com.xebia.domain.commission.CommissionRepository;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ComissionRepositoryTest extends AbstractIntegrationTest {

    @Inject
    private CommissionRepository commissionRepository;

    @Test
    public void should_find_comission_by_id() {
        // Given
        // When
        Commission result = commissionRepository.findOne(1L);

        // Then
        assertThat(result).isNotNull();
    }

}
