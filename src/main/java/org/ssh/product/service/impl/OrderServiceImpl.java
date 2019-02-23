package org.ssh.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.product.dao.OrderDao;
import org.ssh.product.model.Order;
import org.ssh.product.model.OrderGoods;
import org.ssh.product.model.User;
import org.ssh.product.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean creatorder(Order order) {
        return orderDao.caeatOrder(order);
    }

    @Override
    public void addordergoods(OrderGoods orderGoods) {
        orderDao.addordergoods(orderGoods);
    }

    @Override
    public void saveNewOrder(Order order) {

    }

    @Override
    public List<Order> getAllOrder(User user) {
        return orderDao.getAllOrder(user);
    }

    @Override
    public List<OrderGoods> getOrderGoodsByOrder(Order order) {
        return orderDao.getOrderGoodsByOrder(order);
    }

    @Override
    public void updataStatus(long orderid) {
        orderDao.updatdaStatus(orderid);
    }
    public void updataStatus(long orderid,int orderstatus) {
        orderDao.updatdaStatus(orderid,orderstatus);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    @Override
    public List<OrderGoods> getOrderGoodsByOrderid(long orderid) {
        return orderDao.getOrderGoodsByOrderid(orderid);
    }
}
