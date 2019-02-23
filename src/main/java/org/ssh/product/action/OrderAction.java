package org.ssh.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.*;
import org.ssh.product.service.CartService;
import org.ssh.product.service.GoodsService;
import org.ssh.product.service.OrderService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class OrderAction extends ActionSupport {

    List<Cart> cartList;
    private Order order;
    private List<OrderGoods> ordergoodslist = new ArrayList<>();
    String message;
    long orderid;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }


    public String checkoutCart(){
        order = new Order();
        ordergoodslist.clear();
        Map application = ActionContext.getContext().getApplication();
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");
        int userid = user.getUserid();
        //cartList = (List<Cart>) application.get("cartlist");
        cartList = cartService.cartItemList(userid);
        for (int i = 0; i < cartList.size(); i++) {
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setGoodsid(cartList.get(i).getGoodsid());
            orderGoods.setOrdergoodspic(cartList.get(i).getMainpic());
            orderGoods.setOrdergoodstitle(cartList.get(i).getTitle());
            orderGoods.setOrdergoodsprice(cartList.get(i).getPrice());
            orderGoods.setOrdergoodscount(cartList.get(i).getCount());
            orderGoods.setOrdergoodspayment(cartList.get(i).getPrice()*cartList.get(i).getCount());

            //在购物车数据库中删除相应商品,先不删除
            //cartService.removeCartitem(cartList.get(i));
            ordergoodslist.add(orderGoods);
        }

       /*
        long orderid;//订单号
        String useridString = String.valueOf(user.getUserid());
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp =format.format(System.currentTimeMillis());
        String timeString = String.valueOf(timestamp);
        String s = useridString.concat(timeString);
        orderid = Long.parseLong(s);
        order.setOrderid(orderid);*/

        String useridString = String.valueOf(user.getUserid());
        long t = System.currentTimeMillis();//获得当前时间的毫秒数
        Random rd = new Random(t);//作为种子数传入到Random的构造器中
        String timeString = String.valueOf(rd.nextInt(10000));
        String s = useridString.concat(timeString);
         int orderid = Integer.parseInt(s);

        System.out.println(orderid);

        float payment=0;
        for (OrderGoods orderGoods : ordergoodslist) {
            payment += orderGoods.getOrdergoodspayment();
            orderGoods.setOrderid(orderid);
            //orderService.addordergoods(orderGoods);
        }
        System.out.println("payment" +payment);
       // order.setPayment(payment);

        order.setOrderid(orderid);
        //order.setCreattime(timestamp1);
        order.setUserid(user.getUserid());
        order.setPayment(payment);
        order.setPostfee(50);//指定邮费
        order.setPaysum(order.getPayment()+order.getPostfee());
        order.setOrdergoodslist(ordergoodslist);


        application.remove("cartlist");

        session.put("order",order);

       return SUCCESS;

    }

    public String submitOrder(){
       Map session = ActionContext.getContext().getSession();
       //删除购物车内容
        User user = (User) session.get("user");
        cartList = cartService.cartItemList(user.getUserid());
        for (Cart cart : cartList) {
            cartService.removeCartitem(cart);
        }
        //修改购物车显示
        session.put("cartnumber",":"+cartList.size());
       Order order = (Order) session.get("order");
        Timestamp timestamp1 = new java.sql.Timestamp(System.currentTimeMillis());
       order.setCreattime(timestamp1);
       //todo  用户留言
       order.setUsermessage("");
        orderService.creatorder(order);//生成订单
        //保存订单对应的商品
        for (OrderGoods orderGoods : order.getOrdergoodslist()) {
            orderService.addordergoods(orderGoods);
        }
        session.remove("order");
        session.put("cartnumber",":"+0);
       String string =showOrder();

        return string;
    }

    public String payoffOrder(){
       orderService.updataStatus(orderid,1);

        String string =showOrder();

        return string;

    }

    public String confirmOrderReceipt(){
        orderService.updataStatus(orderid,3);

        String string =showOrder();

        return string;

    }

    //发货处理
    public String orderOperation(){
        Map session = ActionContext.getContext().getSession();

        String errorMessage = "";
        //在库存表里减去对应手机id的商品库存数量
        List<OrderGoods> orderGoodsList= orderService.getOrderGoodsByOrderid(orderid);

        for (OrderGoods orderGoods : orderGoodsList) {

            int phonenumber = orderGoods.getOrdergoodscount();
            int ordergoodsid = orderGoods.getGoodsid();
            if(!goodsService.phoneStoreNumberChange(ordergoodsid,phonenumber)){

                errorMessage  = "库存数量不足，发货失败！！！";
                System.out.println(errorMessage);
                addActionMessage(errorMessage);
                session.put("errorMessage",errorMessage);
            }
            else
                orderService.updataStatus(orderid,2);
        }
        return showOrder1();

    }

    public String orderGoodsOperation(){
        Map session = ActionContext.getContext().getSession();
        List<OrderGoods> orderGoodsList= orderService.getOrderGoodsByOrderid(orderid);
        session.put("orderGoodsList",orderGoodsList);

        return SUCCESS;
    }

    public String showOrder(){
        System.out.println("运输test");
        Map session = ActionContext.getContext().getSession();
        session.remove("orderlist");
        User user = (User) session.get("user");
        List<Order> orderList=orderService.getAllOrder(user);
        for (Order order1 : orderList) {
            //long order2=  order1.getOrderid();
            List<OrderGoods> orderGoodsList= orderService.getOrderGoodsByOrder(order1);
            order1.setOrdergoodslist(orderGoodsList);
        }
       // System.out.println("ststus:");
        //System.out.println(orderList.get(0).getOrderstatus());

        session.put("orderlist",orderList);

        return SUCCESS;
    }

    public  String showOrder1(){
        Map session = ActionContext.getContext().getSession();
        List<Order> orderList=orderService.getAllOrder();
        session.put("orderlist",orderList);
        return SUCCESS;
    }
}
