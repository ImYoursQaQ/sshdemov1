package org.ssh.product.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import freemarker.template.utility.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.*;
import org.ssh.product.service.AdminService;
import org.ssh.product.service.GoodsService;
import org.ssh.product.service.OrderService;
import org.ssh.product.service.UserService;
import org.ssh.product.util.SafeUtil;
import org.ssh.product.util.uploadUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AdminAction extends ActionSupport {

    @Autowired
    private AdminService adminService;
    @Autowired
   private OrderService orderService;

    @Autowired
    private  UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private uploadUtil uploadUtil;
    @Autowired
    private SafeUtil safeUtil;


    private User user;

    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private Admin admin;

    private int userid;
    private int goodsid;
    private int idposterTable;
    private int postergoodsid;

    public int getPostergoodsid() {
        return postergoodsid;
    }

    public void setPostergoodsid(int postergoodsid) {
        this.postergoodsid = postergoodsid;
    }

    public int getIdposterTable() {
        return idposterTable;
    }

    public void setIdposterTable(int idposterTable) {
        this.idposterTable = idposterTable;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    private  String storenumber1;

    public String getStorenumber1() {
        return storenumber1;
    }

    public void setStorenumber1(String storenumber1) {
        this.storenumber1 = storenumber1;
    }

    private File upload;// 上传的文件
    private String uploadFileName;//上传的文件名陈
    private String uploadContentType;// 接收文件上传的MIME类型

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String login() throws UnsupportedEncodingException, NoSuchAlgorithmException {
            //加密处理
            String newpass = safeUtil.strToMD5(admin.getAdminPassword());
            admin.setAdminPassword(newpass);
            Admin admintrue = adminService.login(admin);
        if (admintrue!=null) {
            System.out.println("111");
            Map session = ActionContext.getContext().getSession();
           // User trueuser = adminService.findUserByName(user.getUsername());
            session.put("admin", admintrue);
            List<Order> orderList=orderService.getAllOrder();
            session.put("orderlist",orderList);
            session.remove("errorMessage");
            return SUCCESS;
        } else {
            System.out.println("222");
            String message ="用户名或密码错误，请重试！";
            Map session = ActionContext.getContext().getSession();
            session.put("message", message);
            return ERROR;
        }
    }


    public String logout(){
        Map session = ActionContext.getContext().getSession();
        session.remove("admin");

        return SUCCESS;
    }
    public String showAlluser1(){
        Map session = ActionContext.getContext().getSession();
            //session.remove("errorMessage");
        List<User> userList = userService.findAllUser();

        session.put("userList",userList);

        return SUCCESS;
    }

    public String showAlluser(){
        Map session = ActionContext.getContext().getSession();
        session.remove("errorMessage");
        List<User> userList = userService.findAllUser();

        session.put("userList",userList);

        return SUCCESS;
    }

    public String showAllPhone(){
        Map session = ActionContext.getContext().getSession();
        session.remove("errorMessage");
        List<Goods> goodsList = goodsService.getGoodslistAlldetail();
        for (Goods goods1 : goodsList) {
            int storeNumber = goodsService.getGoodsStroeNumber(goods1.getGoodsid());
            goods1.setStoreNumber(storeNumber);
        }

        session.put("goodsList",goodsList);


        return SUCCESS;
    }

    public String showAllPhone1(){
        Map session = ActionContext.getContext().getSession();
        //session.remove("errorMessage");
        List<Goods> goodsList = goodsService.getGoodslistAlldetail();
        for (Goods goods1 : goodsList) {
            int storeNumber = goodsService.getGoodsStroeNumber(goods1.getGoodsid());
            goods1.setStoreNumber(storeNumber);
        }

        session.put("goodsList",goodsList);


        return SUCCESS;
    }

    public String showAllOrder(){
        Map session = ActionContext.getContext().getSession();
        session.remove("errorMessage");
        System.out.println("session.get(\"orderlist\")="+session.get("orderlist"));
        System.out.println("showAllOrder in");
        List<Order> orderList=orderService.getAllOrder();
        session.put("orderlist",orderList);
        System.out.println("session.get(\"orderlist\")="+session.get("orderlist"));
        System.out.println("showAllOrder out");
       // System.out.println(session.get("errorMessage").toString());
        return SUCCESS;
    }

    public String toPhoneAdd(){

        //服务器跳转
        System.out.println("hello!!!");
        return SUCCESS;
    }

    public String deleteUserByadmin(){
        Map session = ActionContext.getContext().getSession();
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

        session.remove("errorMessage");
        Admin admin = (Admin) session.get("admin");
        System.out.println("管理员等级："+admin.getAdminLevel());
        if(admin.getAdminLevel()==10){
            if (userService.deleteUserByid(userid)){
                session.put("errorMessage","操作成功！");
                return showAlluser1();
            }

            else {
                request.put("errorMessage","操作失败！");
                return ERROR;
            }
        }
        else {
            session.put("errorMessage","权限不够，请联系系统管理员！");
            System.out.println("权限不够！");
            return showAlluser1();
        }

    }

    public String showUserByadmin(){
        Map session = ActionContext.getContext().getSession();
        User user = userService.findUserByID(userid);
        session.put("userforadmin",user);
        return SUCCESS;
    }

    public String updataUserByadmin(){
        Map session = ActionContext.getContext().getSession();
        System.out.println(user.getUsername()+user.getAddress());
        userService.updataUser(userid,user);
        session.remove("userforadmin");
        session.remove("errorMessage");
        User newuser = userService.findUserByID(userid);
        System.out.println(newuser.getAddress());
        session.put("userforadmin",newuser);
        return SUCCESS;
    }


    public String PhoneAddByAdmin() throws IOException {
        Map session = ActionContext.getContext().getSession();
        System.out.println(upload.toURI());
        if (upload != null) {
            String picname = uploadUtil.picUpload(upload,uploadFileName);
            if (picname==""){
                return ERROR;
            }
            else{
                goods.setMainpic("/image/"+picname);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                goods.setTimestamp(timestamp);
                goodsService.addPhoneGoods(goods);
                return SUCCESS;
            }

        }
        else {
            return ERROR;
        }
    }

    public String PhoneStoreAddByAdmin(){
        //storenumber;


        return SUCCESS;
    }

    public String PhoneStoreNumberAddByAdmin() {
        Map session = ActionContext.getContext().getSession();
        if (safeUtil.isPureDigital(storenumber1)) {
            int storenumber = Integer.parseInt(storenumber1);
            if (storenumber > 0) {
                goodsService.addPhoneStoreNumber(goodsid, storenumber);
                return showAllPhone();
            }
        }
        session.put("errorMessage", "输入的内容不正确，请输入正整数！");
        return showAllPhone1();
    }

    public  String toPhoneScore(){
        Map session = ActionContext.getContext().getSession();
        Goods currentgoods = goodsService.findGoods(goodsid);
        session.put("currentPhone",currentgoods);
        return SUCCESS;
    }

    public String PhoneScoreByAdmin(){
        Map session = ActionContext.getContext().getSession();

        System.out.println("评分更新测试！");
        System.out.println(goodsid+":");
        System.out.println(goods.getAppearanceScore()+goods.getPerformanceScore()+goods.getPhotoScore());

        goodsService.updadaScore(goodsid,goods);

        Goods newPhone = goodsService.findGoods(goodsid);
        session.put("currentPhone",newPhone);


        return SUCCESS;
    }


    public String showPosterWall(){
        Map session = ActionContext.getContext().getSession();

        List<Poster> posterList =new ArrayList<>();
        posterList.add(goodsService.getPoster(1));
        posterList.add(goodsService.getPoster(2));
        posterList.add(goodsService.getPoster(3));
        session.put("posterList", posterList);
        return SUCCESS;

    }

    public String changePoster() throws IOException{
        Map session = ActionContext.getContext().getSession();
        //System.out.println(upload.toURI());
        if (upload != null) {
            String picname = uploadUtil.picUpload(upload,uploadFileName);
            if (picname==""){
                return ERROR;
            }
            else{


                return SUCCESS;
            }

        }
        else {
            return ERROR;
        }

    }

    public String tochangePage(){

        Map session = ActionContext.getContext().getSession();
        Poster poster = goodsService.getPosterByID(idposterTable);
        session.put("currentposter",poster);

        return SUCCESS;
    }

}

