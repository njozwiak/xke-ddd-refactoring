package com.xebia.domain.user;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        user = new User();
    }

    public User build() {
        return user;
    }

    public UserBuilder firstname(String firstname) {
        user.setFirstname(firstname);
        return this;
    }

    public UserBuilder lastname(String lastname) {
        user.setLastname(lastname);
        return this;
    }

    public UserBuilder email(String email) {
        user.setEmail(email);
        return this;
    }
}
