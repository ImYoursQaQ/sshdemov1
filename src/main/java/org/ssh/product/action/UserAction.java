package org.ssh.product.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.Cart;
import org.ssh.product.model.User;
import org.ssh.product.service.CartService;
import org.ssh.product.service.UserService;
import org.ssh.product.util.SafeUtil;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@Controller
public class UserAction extends ActionSupport {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private SafeUtil safeUtil;

    private User user;

    private String StringOfAddress;

    public String getStringOfAddress() {
        return StringOfAddress;
    }

    public void setStringOfAddress(String stringOfAddress) {
        StringOfAddress = stringOfAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String login() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Map<String, Object> request = (Map)ActionContext.getContext().get("request");
        //用户密码加密
        String newpass = safeUtil.strToMD5(user.getPassword());
        user.setPassword(newpass);
        if (userService.login(user)) {
            Map session = ActionContext.getContext().getSession();

            User trueuser = userService.findUserByName(user.getUsername());
            session.put("user", trueuser);
            List<Cart> cartList = cartService.cartItemList(trueuser.getUserid());
            session.put("cartnumber",":"+cartList.size());
            session.put("cartList", cartList);
            return SUCCESS;
        } else {
            String message ="用户名或密码错误，请重试！";
            Map session = ActionContext.getContext().getSession();
            request.put("errormessage", message);
            return ERROR;
        }
    }

    public String logout(){
        Map session = ActionContext.getContext().getSession();
        session.remove("user");
        session.remove("cartList");
        List<Cart> cartList = null;
        session.put("cartList", cartList);
        session.put("cartnumber","");
       /* List<Cart> cartList1 = (List<Cart>) session.get("cartList");
        System.out.println("gouwuche ");
        System.out.println(cartList1.size());*/
        return SUCCESS;


    }

    public String register() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("11111111111111111111111");
            System.out.println("222222222222:"+user.getUsername());
        System.out.println("加密前："+user.getPassword());
            String newpass = safeUtil.strToMD5(user.getPassword());
            user.setPassword(newpass);
        System.out.println("加密后："+newpass);
            switch (userService.register(user)) {
                case 0: {
                    //this.addActionMessage("保存成功...");

                    String message ="注册成功，返回登录！";
                    Map session = ActionContext.getContext().getSession();
                    session.remove("user");
                    session.put("errormessage", message);
                    System.out.println(message);
                    return SUCCESS;
                }
                case 1: {
                    String errormessage = "手机号码已经注册,请重试...";
                    this.addActionMessage(errormessage);
                    Map session = ActionContext.getContext().getSession();
                    session.put("errorMessage", errormessage);
                    System.out.println("111111111111111111111");
                    System.out.println(session.get("errorMessage"));
                    return ERROR;
                }
                case 2: {
                    String errormessage = "邮箱账号已经注册,请重试...";
                    this.addActionMessage(errormessage);
                    Map session = ActionContext.getContext().getSession();
                    session.put("errorMessage", errormessage);
                    return ERROR;
                }
                default:
                    System.out.println("22222222");
                    return null;
            }
        }

    public String addressSet(){
        Map session = ActionContext.getContext().getSession();
        User user1 = (User) session.get("user");
        if(userService.updataAddress(user1,StringOfAddress))
        return SUCCESS;
        else return ERROR;
    }
}

