package org.ssh.product.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_goods", schema = "demo", catalog = "")
public class OrderGoodsEntity {
    private int ordergoodsid;
    private int orderid;
    private String ordergoodspic;
    private String ordergoodstitle;
    private double ordergoodsprice;
    private int ordergoodscount;
    private double ordergoodspayment;

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
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
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
    public double getOrdergoodsprice() {
        return ordergoodsprice;
    }

    public void setOrdergoodsprice(double ordergoodsprice) {
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
        OrderGoodsEntity that = (OrderGoodsEntity) o;
        return ordergoodsid == that.ordergoodsid &&
                orderid == that.orderid &&
                Double.compare(that.ordergoodsprice, ordergoodsprice) == 0 &&
                ordergoodscount == that.ordergoodscount &&
                Double.compare(that.ordergoodspayment, ordergoodspayment) == 0 &&
                Objects.equals(ordergoodspic, that.ordergoodspic) &&
                Objects.equals(ordergoodstitle, that.ordergoodstitle);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ordergoodsid, orderid, ordergoodspic, ordergoodstitle, ordergoodsprice, ordergoodscount, ordergoodspayment);
    }
}
