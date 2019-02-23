package org.ssh.product.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.ssh.product.dao.AdminDao;
import org.ssh.product.dao.UserDao;
import org.ssh.product.model.Admin;
import org.ssh.product.model.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Repository

public class AdminDaoImpl implements AdminDao {
    private HibernateTemplate template;
    Timestamp timestamp = null;
    List adminlist = null;

    @Autowired
    public AdminDaoImpl(SessionFactory sessionFactory) {

        this.template = new HibernateTemplate(sessionFactory);

    }

    @Override
    public Admin login(Admin admin) {

        System.out.println(admin.getAdminName()+":"+admin.getAdminPassword());

        adminlist = null;

        String hql = "FROM Admin a where a.adminName=? and a.adminPassword=?";
        System.out.println(hql);

        adminlist = template.find(hql, new String[]{admin.getAdminName(), admin.getAdminPassword()});

        System.out.println(adminlist.toString());
        System.out.println("大小");
        System.out.println(adminlist.size());

        if (!adminlist.isEmpty()) {
            System.out.println(adminlist.toString());
            System.out.println("true");
           // timestamp = new Timestamp(System.currentTimeMillis());
            //Admin admin1 = (Admin) adminlist.get(0);
           // admin1.setLsatLogin(timestamp);
            //template.save(admin1);
            Admin admin1 = (Admin) adminlist.get(0);
            return admin1;
        } else {
            System.out.println("false");
            return null;
        }

    }

   /* @Override
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
    }*/

}