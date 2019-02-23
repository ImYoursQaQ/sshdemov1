package org.ssh.product.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phonestore", schema = "demo", catalog = "")
public class PhonestoreEntity {
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
        PhonestoreEntity that = (PhonestoreEntity) o;
        return idphonestore == that.idphonestore &&
                goodsid == that.goodsid &&
                Objects.equals(goodsnumber, that.goodsnumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idphonestore, goodsid, goodsnumber);
    }
}
