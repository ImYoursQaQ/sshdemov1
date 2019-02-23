package org.ssh.product.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Phonecolor {
    private int id;
    private byte colorid;
    private String colorname;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "colorid")
    public byte getColorid() {
        return colorid;
    }

    public void setColorid(byte colorid) {
        this.colorid = colorid;
    }

    @Basic
    @Column(name = "colorname")
    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phonecolor that = (Phonecolor) o;
        return id == that.id &&
                colorid == that.colorid &&
                Objects.equals(colorname, that.colorname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, colorid, colorname);
    }
}
