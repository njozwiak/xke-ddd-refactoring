package com.xebia.user;

import com.xebia.model.Entity;

import static com.google.common.base.Strings.isNullOrEmpty;

public class User extends Entity {

  private String firstname;

  private String lastname;

  private String password;

  private String address;

  private String email;

  private String phoneNumber;

  private Role role;

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPassword() {
    return password;
  }

  protected void setPassword(String password) {
    this.password = password;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public void changePassword(String password) {
    if (isNullOrEmpty(password)) {
      throw new IllegalArgumentException("new password cannot be null");
    }

    this.setPassword(password);
  }
}