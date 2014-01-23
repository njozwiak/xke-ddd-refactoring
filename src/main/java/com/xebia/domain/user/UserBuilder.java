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

    public UserBuilder password(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder address(String address) {
        user.setAddress(address);
        return this;
    }

    public UserBuilder phoneNumber(String phoneNumber) {
        user.setPhoneNumber(phoneNumber);
        return this;
    }

    public UserBuilder withRole(Role role) {
        user.setRole(role);
        return this;
    }
}
