package org.ssh.product.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_order", schema = "demo")
public class Order {
    private long orderid;
    private double payment;
    private double postfee;
    private double paysum;
    private int orderstatus;
    private Timestamp creattime;
    private int userid;
    private String usermessage;
    private List<OrderGoods> ordergoodslist;//数据库没有

    @Transient
    public List<OrderGoods> getOrdergoodslist() {
        return ordergoodslist;
    }

    public void setOrdergoodslist(List<OrderGoods> ordergoodslist) {
        this.ordergoodslist = ordergoodslist;
    }



    @Id
    @Column(name = "orderid")
    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "payment")
    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "postfee")
    public double getPostfee() {
        return postfee;
    }

    public void setPostfee(double postfee) {
        this.postfee = postfee;
    }

    @Basic
    @Column(name = "paysum")
    public double getPaysum() {
        return paysum;
    }

    public void setPaysum(double paysum) {
        this.paysum = paysum;
    }

    @Basic
    @Column(name = "orderstatus")
    public int getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Basic
    @Column(name = "creattime")
    public Timestamp getCreattime() {
        return creattime;
    }

    public void setCreattime(Timestamp creattime) {
        this.creattime = creattime;
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
    @Column(name = "usermessage")
    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderid == order.orderid &&
                Double.compare(order.payment, payment) == 0 &&
                Double.compare(order.postfee, postfee) == 0 &&
                Double.compare(order.paysum, paysum) == 0 &&
                orderstatus == order.orderstatus &&
                userid == order.userid &&
                Objects.equals(creattime, order.creattime) &&
                Objects.equals(usermessage, order.usermessage) &&
                Objects.equals(ordergoodslist, order.ordergoodslist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderid, payment, postfee, orderstatus, creattime, userid,usermessage);
    }
}
