package com.xebia.domain.comission;

import com.google.inject.Inject;
import com.xebia.AbstractIntegrationTest;
import com.xebia.domain.comission.Comission;
import com.xebia.domain.comission.ComissionRepository;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

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
