package org.ssh.product.service;

import org.ssh.product.model.Order;
import org.ssh.product.model.OrderGoods;
import org.ssh.product.model.User;

import java.util.List;

public interface OrderService {
    
    boolean creatorder(Order order);

    void addordergoods(OrderGoods orderGoods);

    void saveNewOrder(Order order);
    List<Order> getAllOrder(User user);

    List<OrderGoods> getOrderGoodsByOrder(Order order);

    void updataStatus(long orderid);
    void updataStatus(long orderid,int orderstatus);

    List<Order> getAllOrder();

    List<OrderGoods> getOrderGoodsByOrderid(long orderid);
}
