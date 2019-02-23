package org.ssh.product.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.ssh.product.dao.UserDao;
import org.ssh.product.model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Repository

public class UserDaoImpl implements UserDao {
    private HibernateTemplate template;
    Timestamp timestamp = null;
    List userList = null;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {

        this.template = new HibernateTemplate(sessionFactory);

    }

    @Override
    public boolean login(User user) {

        userList = null;

        String hql = "FROM User u where u.username=? and u.password=?";
        System.out.println(hql);

        userList = template.find(hql, new String[]{user.getUsername(), user.getPassword()});

        System.out.println(userList.toString());

        if (!userList.isEmpty()) {
            System.out.println(userList.toString());
            System.out.println("true");
            timestamp = new Timestamp(System.currentTimeMillis());
            User user1 = (User) userList.get(0);
            user1.setLsatLogin(timestamp);
            template.save(user1);
            return true;
        } else {
            System.out.println("false");
            return false;
        }

    }

    @Override
    public int register(User user) {
        int flag;
        if (!findByPhone(user).isEmpty()) {

            flag = 1;//手机号重复
            System.out.println(flag);
            return flag;

        } else {
            if (!findByEmail(user).isEmpty()) {
                flag = 2;//邮箱重复
                System.out.println(flag);
                return flag;
            } else {
                flag = 0;
                Random rand = new Random();
                int id = rand.nextInt(9000) + 100;
                timestamp = new Timestamp(System.currentTimeMillis());
                user.setUserid(id);
                user.setCreated(timestamp);
                template.save(user);
                System.out.println(flag);
                return flag;
            }
        }
    }

    @Override
    public User findUserByName(String username) {

        String hql = "FROM User u where u.username=?";
        userList = template.find(hql,username);
        User user = (User) userList.get(0);
        return user;
    }

    @Override
    public User findUserByID(int userid) {
        String hql = "FROM User u where u.userid=?";
        userList = template.find(hql,userid);
        User user = (User) userList.get(0);
        return user;
    }

    @Override
    public boolean updataAddress(User user, String stringOfAddress) {

        System.out.println("updataAddresstest：");
        System.out.println(user.getUsername());

        user.setAddress(stringOfAddress);
        template.update(user);

        return true;
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList;
        String hql ="FROM User";
        userList = (List<User>) template.find(hql);
        System.out.println("1122344");
        System.out.println(userList.size());
        return userList;
    }

    @Override
    public void updataUser(int userid, User user) {
        User user1 = findUserByID(userid);
        user1.setUsername(user.getUsername());
        user1.setPhone(user.getPhone());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        template.save(user1);
    }

    @Override
    public boolean deleteUserByid(int userid) {
        User user1 = findUserByID(userid);
        if (user1!=null) {
            template.delete(user1);
            return true;
        }
        else
            return false;

    }


    public List<User> findByPhone(User user) {
        userList = new ArrayList();
        String hql = "FROM User u where u.phone=?";
        System.out.println(hql);

        userList = template.find(hql, user.getPhone());
        System.out.println("error: flag = 1");
        return userList;
    }

    public List<User> findByEmail(User user) {
        userList = new ArrayList();
        String hql = "FROM User u where u.email=?";
        System.out.println(hql);
        System.out.println(user.getEmail());
        System.out.println("error: flag = 2");
        System.out.println(userList.toString());
        userList = template.find(hql, user.getEmail());
        System.out.println(userList.toString());
        return userList;
    }

    public List<User> findByUserid(User user) {
        userList = new ArrayList();
        String hql = "FROM User u where u.userid=?";
        System.out.println(hql);

        userList = template.find(hql, user.getUserid());
        return userList;
    }

}