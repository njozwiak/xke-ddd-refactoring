package com.xebia.domain.user;

import static com.google.common.collect.Lists.newArrayList;

// Simulation d'une application externe
public class UserService {

  public User getUserById(Long id) {

    User user = new User();
    user.setFirstname("firstName_" + id);
    user.setLastname("lastName_" + id);
    user.setAddress("address_" + id);
    user.setEmail("email_" + id);
    user.setPhoneNumber("number_" + id);

    Role role = new Role();
    role.setUser(user);
    if (id % 2 == 0) {
      role.setRoleName("trader");
      user.setRoles(newArrayList(role));
    } else {
      role.setRoleName("pricer");
      user.setRoles(newArrayList(role));
    }

    return user;
  }
}
