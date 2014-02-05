package com.xebia.service;

import com.xebia.domain.user.User;

/**
 * Created with IntelliJ IDEA.
 * User: jean-eudes
 * Date: 05/02/14
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    User getUserById(Long id);

    // MOVE TO USER
    void changePasswordForUser(Long userId, String password);
}
