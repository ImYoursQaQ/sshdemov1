package org.ssh.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.product.dao.AdminDao;
import org.ssh.product.dao.UserDao;
import org.ssh.product.model.Admin;
import org.ssh.product.model.User;
import org.ssh.product.service.AdminService;
import org.ssh.product.service.UserService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(Admin admin) {
        return  adminDao.login(admin);
    }
}
