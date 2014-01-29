package com.xebia.repository;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.Comission;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class ComissionRepositoryTest extends AbstractIntegrationTest {

    @Inject
    private ComissionRepository comissionRepository;

    @Test
    public void should_find_comission_by_id() {
        // Given
        // When
        Comission result = comissionRepository.findOne(1L);

        // Then
        assertThat(result).isNotNull();
    }

}
