package org.ssh.product.service;

import org.ssh.product.model.User;

import java.util.List;

public interface UserService {
    boolean login(User user);

    int register(User user);

    User findUserByName(String username);

    User findUserByID(int userid);

    boolean updataAddress(User user, String stringOfAddress);

    List<User> findAllUser();

    void updataUser(int userid, User user);

    boolean deleteUserByid(int userid);
}
