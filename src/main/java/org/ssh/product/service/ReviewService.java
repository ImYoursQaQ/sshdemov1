package org.ssh.product.service;

import org.ssh.product.model.TReview;

import java.util.List;

public interface ReviewService {
    void addNewReview(TReview tReview);

    List<TReview> getReviewByGoodsid(int goodsid);
}
