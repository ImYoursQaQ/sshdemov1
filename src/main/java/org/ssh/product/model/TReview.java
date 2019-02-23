package org.ssh.product.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "t_review", schema = "demo")
public class TReview {
    private int reviewid;
    private int userid;
    private int goodsid;
    private Timestamp reviewTime;
    private Double userforgoodsScore;
    private String userreviewtext;

    //不插入数据库
    private String username;

    @Transient
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "reviewid")
    public int getReviewid() {
        return reviewid;
    }

    public void setReviewid(int reviewid) {
        this.reviewid = reviewid;
    }

    @Basic
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "goodsid")
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    @Basic
    @Column(name = "review_time")
    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Basic
    @Column(name = "userforgoods_score")
    public Double getUserforgoodsScore() {
        return userforgoodsScore;
    }

    public void setUserforgoodsScore(Double userforgoodsScore) {
        this.userforgoodsScore = userforgoodsScore;
    }

    @Basic
    @Column(name = "userreviewtext")
    public String getUserreviewtext() {
        return userreviewtext;
    }

    public void setUserreviewtext(String userreviewtext) {
        this.userreviewtext = userreviewtext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TReview tReview = (TReview) o;
        return reviewid == tReview.reviewid &&
                userid == tReview.userid &&
                goodsid == tReview.goodsid &&
                Objects.equals(reviewTime, tReview.reviewTime) &&
                Objects.equals(userforgoodsScore, tReview.userforgoodsScore) &&
                Objects.equals(userreviewtext, tReview.userreviewtext);
    }

    @Override
    public int hashCode() {

        return Objects.hash(reviewid, userid, goodsid, reviewTime, userforgoodsScore, userreviewtext);
    }
}
