package org.ssh.product.service;

import org.ssh.product.model.Admin;
import org.ssh.product.model.User;

public interface AdminService {
    Admin login(Admin admin);

   /* int register(User user);

    User findUserByName(String username);

    User findUserByID(int userid);

    boolean updataAddress(User user, String stringOfAddress);*/
}
