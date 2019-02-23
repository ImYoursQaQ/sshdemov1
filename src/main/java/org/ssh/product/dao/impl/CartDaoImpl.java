package org.ssh.product.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.ssh.product.dao.CartDao;
import org.ssh.product.model.Cart;

import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    private HibernateTemplate template;



    @Autowired
    public CartDaoImpl(SessionFactory sessionFactory) {

        this.template = new HibernateTemplate(sessionFactory);

    }
    @Override//更新或保存新的
    public void addCartItem(Cart cart) {
        template.saveOrUpdate(cart);
        System.out.println("加入数据库中");
    }

    @Override//加载所有cartitem
    public List<Cart> cartItemList(int userid) {
        String hql = "FROM Cart c where c.userid=?";
        List<Cart> cartList = (List<Cart>) template.find(hql,userid);
        return cartList;
    }

    @Override
    public void removeCartItem(Cart cart1) {
        template.delete(cart1);
        System.out.println("移出购物车");
    }

}
