package org.ssh.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.product.dao.UserDao;
import org.ssh.product.model.User;
import org.ssh.product.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public boolean login(User user){
       return userDao.login(user);
    }

    @Override
    public int register(User user) {
        return userDao.register(user);
    }

    @Override
    public User findUserByName(String username) {
        return userDao.findUserByName(username);
    }

    @Override
    public User findUserByID(int userid) {
        return userDao.findUserByID(userid);
    }

    @Override
    public boolean updataAddress(User user, String stringOfAddress) {
        return userDao.updataAddress(user,stringOfAddress);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void updataUser(int userid, User user) {
        userDao.updataUser(userid,user);

    }

    @Override
    public boolean deleteUserByid(int userid) {
        return userDao.deleteUserByid(userid);
    }


}
