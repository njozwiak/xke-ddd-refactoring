package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.EcheanceRequest;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class EcheanceRequestRepositoryIntegrationTest extends AbstractIntegrationTest {

    @Inject
    private EcheanceRequestRepository echeanceRequestRepository;

    @Test
    public void should_find_echeance_by_id() {
        // Given
        // When
        EcheanceRequest result = echeanceRequestRepository.findOne(1L);

        // Then
        assertThat(result).isNotNull();
    }
}
