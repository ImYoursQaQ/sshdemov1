package org.ssh.product.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.ssh.product.dao.OrderDao;
import org.ssh.product.model.Order;
import org.ssh.product.model.OrderGoods;
import org.ssh.product.model.User;

import java.util.List;

@Repository
public class OrderDaoImpl  implements OrderDao{
    private HibernateTemplate template;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {

        this.template = new HibernateTemplate(sessionFactory);

    }


    @Override
    public boolean caeatOrder(Order order) {
        //String hql = "insert into order (creattime, payment, paysum, postfee, orderstatus, userid, usermessage, orderid) values (?, ?, ?, ?, ?, ?, ?, ?)";
        template.save(order);
        return true;
    }

    @Override
    public void addordergoods(OrderGoods orderGoods) {
        template.save(orderGoods);
    }

    @Override
    public List<Order> getAllOrder(User user) {
        int userid = user.getUserid();
        String hql = "FROM Order o where o.userid=? order by o.creattime";
        List<Order> orderList= (List<Order>) template.find(hql,userid);
        //测试
       // System.out.println("test:"+orderList.get(0).getOrderid());
        return orderList;
    }

    @Override
    public List<OrderGoods> getOrderGoodsByOrder(Order order) {
        long orderid = order.getOrderid();
        System.out.println(orderid);
        String hql ="FROM OrderGoods og where og.orderid=?";
        List<OrderGoods> orderGoodsList = (List<OrderGoods>) template.find(hql,orderid);
        //测试
        System.out.println("test:"+orderGoodsList.size());
        return orderGoodsList;
    }

    @Override
    public void updatdaStatus(long orderid) {
        Order order = findOrderByID(orderid);
        order.setOrderstatus(1);//修改订单状态为1  等待发货
        template.update(order);

    }

    @Override
    public void updatdaStatus(long orderid,int orderstatus) {
        Order order = findOrderByID(orderid);
        System.out.println("111111111111111111111111");
        System.out.println(orderstatus);
        order.setOrderstatus(orderstatus);//修改订单状态为1  等待发货;2为运输中
        template.update(order);

    }

    @Override
    public List<Order> getAllOrder() {
        //String hql = "FROM Order";
        String hql = "FROM Order o order by o.creattime";
        List<Order> orderList= (List<Order>) template.find(hql);
        System.out.println("结果");
        System.out.println(orderList.size());
        return orderList;
    }

    @Override
    public List<OrderGoods> getOrderGoodsByOrderid(long orderid) {
        String hql ="FROM OrderGoods og where og.orderid=?";
        List<OrderGoods> orderGoodsList = (List<OrderGoods>) template.find(hql,orderid);
        return orderGoodsList;
    }

    public Order findOrderByID(long orderid){
        String hql = "FROM Order o where o.orderid=?";
        List<Order> orderList = (List<Order>) template.find(hql,orderid);
        Order order = orderList.get(0);
        return order;
    }
}
