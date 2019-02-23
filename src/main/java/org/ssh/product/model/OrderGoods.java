package org.ssh.product.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_goods", schema = "demo", catalog = "")
public class OrderGoods {
    private int ordergoodsid;
    private long orderid;
    private String ordergoodspic;
    private String ordergoodstitle;
    private float ordergoodsprice;
    private int ordergoodscount;
    private double ordergoodspayment;
    private int goodsid;

    @Column(name = "goodsid")
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    @Id
    @Column(name = "ordergoodsid")
    public int getOrdergoodsid() {
        return ordergoodsid;
    }

    public void setOrdergoodsid(int ordergoodsid) {
        this.ordergoodsid = ordergoodsid;
    }

    @Basic
    @Column(name = "orderid")
    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "ordergoodspic")
    public String getOrdergoodspic() {
        return ordergoodspic;
    }

    public void setOrdergoodspic(String ordergoodspic) {
        this.ordergoodspic = ordergoodspic;
    }

    @Basic
    @Column(name = "ordergoodstitle")
    public String getOrdergoodstitle() {
        return ordergoodstitle;
    }

    public void setOrdergoodstitle(String ordergoodstitle) {
        this.ordergoodstitle = ordergoodstitle;
    }

    @Basic
    @Column(name = "ordergoodsprice")
    public float getOrdergoodsprice() {
        return ordergoodsprice;
    }

    public void setOrdergoodsprice(float ordergoodsprice) {
        this.ordergoodsprice = ordergoodsprice;
    }

    @Basic
    @Column(name = "ordergoodscount")
    public int getOrdergoodscount() {
        return ordergoodscount;
    }

    public void setOrdergoodscount(int ordergoodscount) {
        this.ordergoodscount = ordergoodscount;
    }

    @Basic
    @Column(name = "ordergoodspayment")
    public double getOrdergoodspayment() {
        return ordergoodspayment;
    }

    public void setOrdergoodspayment(double ordergoodspayment) {
        this.ordergoodspayment = ordergoodspayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderGoods that = (OrderGoods) o;
        return ordergoodsid == that.ordergoodsid &&
                orderid == that.orderid &&
                ordergoodscount == that.ordergoodscount &&
                Double.compare(that.ordergoodspayment, ordergoodspayment) == 0 &&
                Objects.equals(ordergoodspic, that.ordergoodspic) &&
                Objects.equals(ordergoodstitle, that.ordergoodstitle) &&
                Objects.equals(ordergoodsprice, that.ordergoodsprice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ordergoodsid, orderid, ordergoodspic, ordergoodstitle, ordergoodsprice, ordergoodscount, ordergoodspayment);
    }
}
