package org.ssh.product.dao;

import org.ssh.product.model.TReview;

import java.util.List;

public interface ReviewDao {
    void addNewReview(TReview tReview);

    List<TReview> getReviewByGoodsid(int goodsid);
}
