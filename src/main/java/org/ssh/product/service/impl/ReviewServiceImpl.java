package org.ssh.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.product.dao.ReviewDao;
import org.ssh.product.model.TReview;
import org.ssh.product.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;
    @Override
    public void addNewReview(TReview tReview) {
        reviewDao.addNewReview(tReview);
    }

    @Override
    public List<TReview> getReviewByGoodsid(int goodsid) {
        return reviewDao.getReviewByGoodsid(goodsid);
    }
}
