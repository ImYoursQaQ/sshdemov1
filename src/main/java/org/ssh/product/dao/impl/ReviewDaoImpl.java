package org.ssh.product.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.ssh.product.dao.ReviewDao;
import org.ssh.product.model.Goods;
import org.ssh.product.model.TReview;
import org.ssh.product.service.GoodsService;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    private HibernateTemplate template;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    public ReviewDaoImpl(SessionFactory sessionFactory) {

        this.template = new HibernateTemplate(sessionFactory);

    }

    @Override
    public void addNewReview(TReview tReview) {
        //先去库里找评分记录
        List<TReview> tReviewList =getReviewByGoodsidAndUserid(tReview.getGoodsid(),tReview.getUserid());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        tReview.setReviewTime(timestamp);
        template.save(tReview);


        //评分更改，刷分过滤
        if(tReviewList.size()==0){//未提交过评分

            //todo评分过滤
            System.out.println("未提交过评分，计入统计！！");
            Goods goods=goodsService.findGoods(tReview.getGoodsid());

            System.out.println("当前分数："+goods.getUserScore());
            int numberofuserscore = goods.getUserScoreNumber()+1;
            double sumofscore = goods.getUserScore()*goods.getUserScoreNumber()+tReview.getUserforgoodsScore();
            System.out.println("新的总分："+sumofscore);
            System.out.println("新的人数"+numberofuserscore);
            double newuserscore = sumofscore/numberofuserscore;
            goods.setUserScore(newuserscore);
            goods.setUserScoreNumber(numberofuserscore);
            System.out.println("分数更新："+goods.getUserScore());
            template.save(goods);
        }

    }

    @Override
    public List<TReview> getReviewByGoodsid(int goodsid) {
        String hql = "FROM TReview tr where tr.goodsid=?";
       List<TReview> tReviewList = (List<TReview>) template.find(hql,goodsid);
        return tReviewList;
    }

    public List<TReview> getReviewByGoodsidAndUserid(int goodsid,int userid){

        String hql = "FROM TReview tr where tr.goodsid=?and tr.userid=?";
        List<TReview> tReviewList = (List<TReview>) template.find(hql,goodsid,userid);
        return tReviewList;
    }
}
