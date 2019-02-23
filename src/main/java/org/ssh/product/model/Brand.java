package org.ssh.product.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Brand {
    private int id;
    private byte brandid;
    private String brandname;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brandid")
    public byte getBrandid() {
        return brandid;
    }

    public void setBrandid(byte brandid) {
        this.brandid = brandid;
    }

    @Basic
    @Column(name = "brandname")
    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return id == brand.id &&
                brandid == brand.brandid &&
                Objects.equals(brandname, brand.brandname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, brandid, brandname);
    }
}
