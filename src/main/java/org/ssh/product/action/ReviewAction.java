package org.ssh.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.Goods;
import org.ssh.product.model.TReview;
import org.ssh.product.model.User;
import org.ssh.product.service.GoodsService;
import org.ssh.product.service.ReviewService;

import java.util.Map;

@Controller
public class ReviewAction extends ActionSupport{

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ReviewService reviewService;

    private detailAction detailAction1;


    private int goodsid;

    private TReview userreview;

    public TReview getUserreview() {
        return userreview;
    }

    public void setUserreview(TReview userreview) {
        this.userreview = userreview;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    public String userSumbitReview(){
        Map session = ActionContext.getContext().getSession();
        User user = (User) session.get("user");
        //Goods goods = goodsService.findGoods(goodsid);
        System.out.println("评论测试：");
        System.out.println(goodsid);
        System.out.println(userreview.getUserforgoodsScore());
        userreview.setGoodsid(goodsid);
        userreview.setUserid(user.getUserid());
        reviewService.addNewReview(userreview);

        return SUCCESS;
    }

}
