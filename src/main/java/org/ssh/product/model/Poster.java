package org.ssh.product.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "poster_table", schema = "demo", catalog = "")
public class Poster {
    private int idposterTable;
    private Integer goodsid;
    private String posterPath;
    private Integer posterLoc;

    @Id
    @Column(name = "idposter_table")
    public int getIdposterTable() {
        return idposterTable;
    }

    public void setIdposterTable(int idposterTable) {
        this.idposterTable = idposterTable;
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
    @Column(name = "poster_path")
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    @Basic
    @Column(name = "poster_loc")
    public Integer getPosterLoc() {
        return posterLoc;
    }

    public void setPosterLoc(Integer posterLoc) {
        this.posterLoc = posterLoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poster poster = (Poster) o;
        return idposterTable == poster.idposterTable &&
                Objects.equals(goodsid, poster.goodsid) &&
                Objects.equals(posterPath, poster.posterPath) &&
                Objects.equals(posterLoc, poster.posterLoc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idposterTable, goodsid, posterPath, posterLoc);
    }
}
