package org.ssh.product.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart", schema = "demo")
public class Cart {
    private int cartitemid;
    private Integer goodsid;
    private String title;
    private String mainpic;
    private float price;
    private int count;

    private Integer userid;
    private Goods goods;//数据库中没有此属性
    //private long orderid;
    @Transient
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    /*public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }*/

    @Id
    @Column(name = "cartitemid")
    public int getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(int cartitemid) {
        this.cartitemid = cartitemid;
    }

    @Basic
    @Column(name = "goodsid")
    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "mainpic")
    public String getMainpic() {
        return mainpic;
    }

    public void setMainpic(String mainpic) {
        this.mainpic = mainpic;
    }

    @Basic
    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Basic
    @Column(name = "count")
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart that = (Cart) o;
        return cartitemid == that.cartitemid &&
                count == that.count &&
                Objects.equals(goodsid, that.goodsid) &&
                Objects.equals(title, that.title) &&
                Objects.equals(mainpic, that.mainpic) &&
                Objects.equals(price, that.price) &&
                Objects.equals(userid, that.userid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cartitemid, goodsid, title, mainpic, price, count,userid);
    }
}
