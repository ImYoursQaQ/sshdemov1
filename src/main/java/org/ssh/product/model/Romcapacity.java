package org.ssh.product.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Romcapacity {
    private int id;
    private byte roMcapacityid;
    private String roMcapacityname;
    private int rom;


    @Basic
    @Column(name = "ROM")
    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROMcapacityid")
    public byte getRoMcapacityid() {
        return roMcapacityid;
    }

    public void setRoMcapacityid(byte roMcapacityid) {
        this.roMcapacityid = roMcapacityid;
    }

    @Basic
    @Column(name = "ROMcapacityname")
    public String getRoMcapacityname() {
        return roMcapacityname;
    }

    public void setRoMcapacityname(String roMcapacityname) {
        this.roMcapacityname = roMcapacityname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Romcapacity that = (Romcapacity) o;
        return id == that.id &&
                roMcapacityid == that.roMcapacityid &&
                Objects.equals(roMcapacityname, that.roMcapacityname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, roMcapacityid, roMcapacityname);
    }
}
