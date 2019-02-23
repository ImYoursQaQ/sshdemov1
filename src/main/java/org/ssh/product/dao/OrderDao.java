package org.ssh.product.dao;

import org.ssh.product.model.Order;
import org.ssh.product.model.OrderGoods;
import org.ssh.product.model.User;

import java.util.List;

public interface OrderDao {
     boolean caeatOrder(Order order);

     void addordergoods(OrderGoods orderGoods);

    List<Order> getAllOrder(User user);

    List<OrderGoods> getOrderGoodsByOrder(Order order);

    void updatdaStatus(long orderid);

    void updatdaStatus(long orderid,int orderstatus);

    List<Order> getAllOrder();

    List<OrderGoods> getOrderGoodsByOrderid(long orderid);
}
