package com.xebia.domain.user;

import com.xebia.domain.user.User;
import com.xebia.domain.user.UserService;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class UserServiceTest {

  @Test
  public void should_get_user_by_id() throws Exception {
    UserService userService = new UserService();

    User user = userService.getUserById(2L);

    assertThat(user.getFirstname()).isEqualTo("firstName_2");
    assertThat(user.getRoles().get(0).getRoleName()).isEqualTo("trader");
  }
}
