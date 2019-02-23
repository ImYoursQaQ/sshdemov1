package org.ssh.product.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Phonestore {
    private int idphonestore;
    private int goodsid;
    private Integer goodsnumber;

    @Id
    @Column(name = "idphonestore")
    public int getIdphonestore() {
        return idphonestore;
    }

    public void setIdphonestore(int idphonestore) {
        this.idphonestore = idphonestore;
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
    @Column(name = "goodsnumber")
    public Integer getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(Integer goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phonestore that = (Phonestore) o;
        return idphonestore == that.idphonestore &&
                goodsid == that.goodsid &&
                Objects.equals(goodsnumber, that.goodsnumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idphonestore, goodsid, goodsnumber);
    }
}
