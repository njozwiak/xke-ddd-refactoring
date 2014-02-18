package com.xebia.user;

// Simulation d'une application externe
public class UserService {

    public User getUserById(Long id) {

        UserBuilder userBuilder = new UserBuilder().firstname("firstName_" + id)
                .lastname("lastName_" + id)
                .password("password_" + id)
                .address("address_" + id)
                .email("email_" + id)
                .phoneNumber("number_" + id);

        Role role = new Role();

        if (id % 2 == 0) {
            role.setRoleName("trader");
            userBuilder.withRole(role);
        } else {
            role.setRoleName("pricer");
            userBuilder.withRole(role);
        }

        User user = userBuilder.build();
        role.setUser(user);

        return user;
    }
}
