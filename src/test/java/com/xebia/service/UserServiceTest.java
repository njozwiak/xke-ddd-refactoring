package com.xebia.service;

import com.xebia.domain.User;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class UserServiceTest {

    @Test
    public void should_get_user_by_id() throws Exception {
        UserService userService = new UserService();

        User user = userService.getUserById(2L);

        assertThat(user.getFirstname()).isEqualTo("firstName_2");
        assertThat(user.getRole().getRoleName()).isEqualTo("trader");
    }
}
