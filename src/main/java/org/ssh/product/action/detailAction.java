package org.ssh.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.*;
import org.ssh.product.service.GoodsService;
import org.ssh.product.service.ReviewService;
import org.ssh.product.service.UserService;

import java.util.List;
import java.util.Map;

@Controller
public class detailAction extends ActionSupport{

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;
    private int goodsid;

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }




    public String detailOfGoods(){
        Map session = ActionContext.getContext().getSession();
        System.out.println("detail result  11111111111:"+goodsid);
        Goods goods = goodsService.findGoods(goodsid);
        List<TReview> tReviewList = reviewService.getReviewByGoodsid(goodsid);
        for (TReview tReview : tReviewList) {
            User user1 = userService.findUserByID(tReview.getUserid());
            tReview.setUsername(user1.getUsername());
        }
        Phonecolor phonecolor = goodsService.getColor(goods.getColorid());
        Romcapacity romcapacity = goodsService.getRom(goods.getRomcapacityid());
        Brand brand = goodsService.listBrandbyid(goods.getBrandid());
        session.put("brand",brand);
        session.put("goods",goods);
        session.put("phonecolor",phonecolor);
        session.put("rom",romcapacity);
        session.put("tReviewList",tReviewList);
        System.out.println("detail result  :"+goods);
        return SUCCESS;

    }




}
