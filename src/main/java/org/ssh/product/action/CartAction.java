package org.ssh.product.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import javafx.application.Application;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.Cart;
import org.ssh.product.model.Goods;
import org.ssh.product.model.User;
import org.ssh.product.service.CartService;
import org.ssh.product.service.GoodsService;
import org.ssh.product.service.UserService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class CartAction extends ActionSupport{


    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

//    private User user;
//    private Goods goods;
    private int userid;
    private int goodsid;
    private int inputcount;

    public int getInputcount() {
        return inputcount;
    }

    public void setInputcount(int inputcount) {
        this.inputcount = inputcount;
    }


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }
    public String addCartItem(){
        Map session = ActionContext.getContext().getSession();
        Map<String, Object> request = (Map)ActionContext.getContext().get("request");
        User user1  = (User) session.get("user");
        if (user1!=null) {
            //  ApplicationContext applicationContext = (ApplicationContext) ActionContext.getContext();
            Map application = ActionContext.getContext().getApplication();

            User user = userService.findUserByID(userid);

            Goods goods = goodsService.findGoods(goodsid);
            List<Cart> cartList;
            Cart cart = null;
            // cartList =(List<Cart>) application.get("cartlist");
            cartList = cartService.cartItemList(userid);
            if (cartList == null)
                cartList = new ArrayList<>();
            else {
                for (Cart cart0 : cartList) {
                    if (cart0.getGoodsid() == goodsid)
                        cart = cart0;
                    break;
                }
            }
            if (null == cart) {
                cart = new Cart();//是加入购物车
                long orderid;//订单号

                String useridString = String.valueOf(user.getUserid());
                DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//         String  timestamp = new Timestamp(System.currentTimeMillis());
                String timestamp = format.format(System.currentTimeMillis());
                String timeString = String.valueOf(timestamp);
                String s = useridString.concat(timeString);
                System.out.println("time :" + timeString);
                System.out.println(s);
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Long.MAX_VALUE);
                orderid = Long.parseLong(s);

                cart.setGoodsid(goods.getGoodsid());
                cart.setMainpic(goods.getMainpic());
                cart.setTitle(goods.getTitle());
                cart.setPrice(goods.getPrice());
                cart.setCount(inputcount);
                //cart.setOrderid(orderid);
//        cart.setGoods(goods);
                cart.setUserid(user.getUserid());
                cartService.addCartItem(cart);//保存
                cartList.add(cart);
            } else {//更新购物车中手机商品数量
                cart.setCount(cart.getCount() + inputcount);
                cartService.addCartItem(cart);//更新
            }

            session.put("cartnumber",":"+cartList.size());
            session.put("cartlist", cartList);
            //存放在session里面


            System.out.println("Cart result:goodsid=" + goodsid);
            System.out.println("userid" + userid);
            System.out.println("inputCount:" + inputcount);


            return SUCCESS;
        }

        else {
            String errormessage = "请先登录！";
            session.put("message",errormessage);
            request.put("errormessage","请登录后使用");
            return ERROR;
        }
    }


    //删除购物车item
    public String delCartItem(){

        //cartList =(List<Cart>) application.get("cartlist");
        Map session = ActionContext.getContext().getSession();
        session.remove("cartlist");
        Map application = ActionContext.getContext().getApplication();
        List<Cart> cartList;


        cartList = cartService.cartItemList(userid);
        if (cartList==null)
            cartList = new ArrayList<>();
        else{
            for (Cart cart1 : cartList) {
                if (cart1.getGoodsid()==goodsid)

                {cartList.remove(cart1);
                cartService.removeCartitem(cart1);
                    break;}
            }}
        session.put("cartnumber",":"+cartList.size());
        session.put("cartlist",cartList);



        return SUCCESS;
    }

    public String showCartlist(){

        Map session = ActionContext.getContext().getSession();
        Map<String, Object> request = (Map)ActionContext.getContext().get("request");
        User user = (User) session.get("user");

        if (user==null){
            System.out.println("未登录测试");
            request.put("errormessage","请登录后使用");
            return ERROR;
        }
        else {
            int userid1 = user.getUserid();
            List<Cart> cartList= cartService.cartItemList(userid1);
            session.put("cartlist",cartList);
            return SUCCESS;
        }

    }



}
