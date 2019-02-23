package org.ssh.product.model;

import javax.persistence.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Goods {
    private int id;
    private int goodsid;
    private String title;
    private byte brandid;
    private String model;
    private float price;
    private String mainpic;
    private String timetomarket;
    private String networkmode;
    private String os;
    private byte colorid;
    private String size;
    private double weight;
    private String material;
    private int batterycapacity;
    private double screensize;
    private String resolutionratio;
    private String ppi;
    private String cpumessage;
    private String gpumessage;
    private byte romcapacityid;
    private String ram;
    private String pixelnumberofblack;
    private String pixelnumberoffront;
    private String aperture;
    private String function;
    private String others;
    private String packing;
    private double appearanceScore;
    private double performanceScore;
    private double photoScore;
    private double userScore;
    private int userScoreNumber;//评分人数
    private Timestamp timestamp;

    @Basic
    @Column(name = "created_time")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name = "userScoreNumber")
    public int getUserScoreNumber() {
        return userScoreNumber;
    }

    public void setUserScoreNumber(int userScoreNumber) {
        this.userScoreNumber = userScoreNumber;
    }

    //不写入数据库
    private double comprehensiveScore;
    private int storeNumber;

    @Transient
    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    @Transient
    public double getComprehensiveScore() {
        return comprehensiveScore;
    }

    public void setComprehensiveScore(double comprehensiveScore) {
        this.comprehensiveScore = comprehensiveScore;
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
    @Column(name = "goodsid")
    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
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
    @Column(name = "brandid")
    public byte getBrandid() {
        return brandid;
    }

    public void setBrandid(byte brandid) {
        this.brandid = brandid;
    }

    @Basic
    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
    @Column(name = "mainpic")
    public String getMainpic() {
        return mainpic;
    }

    public void setMainpic(String mainpic) {
        this.mainpic = mainpic;
    }

    @Basic
    @Column(name = "timetomarket")
    public String getTimetomarket() {
        return timetomarket;
    }

    public void setTimetomarket(String timetomarket) {
        this.timetomarket = timetomarket;
    }

    @Basic
    @Column(name = "networkmode")
    public String getNetworkmode() {
        return networkmode;
    }

    public void setNetworkmode(String networkmode) {
        this.networkmode = networkmode;
    }

    @Basic
    @Column(name = "os")
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
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
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "weight")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Basic
    @Column(name = "batterycapacity")
    public int getBatterycapacity() {
        return batterycapacity;
    }

    public void setBatterycapacity(int batterycapacity) {
        this.batterycapacity = batterycapacity;
    }

    @Basic
    @Column(name = "screensize")
    public double getScreensize() {
        return screensize;
    }

    public void setScreensize(double screensize) {
        this.screensize = screensize;
    }

    @Basic
    @Column(name = "resolutionratio")
    public String getResolutionratio() {
        return resolutionratio;
    }

    public void setResolutionratio(String resolutionratio) {
        this.resolutionratio = resolutionratio;
    }

    @Basic
    @Column(name = "ppi")
    public String getPpi() {
        return ppi;
    }

    public void setPpi(String ppi) {
        this.ppi = ppi;
    }

    @Basic
    @Column(name = "cpumessage")
    public String getCpumessage() {
        return cpumessage;
    }

    public void setCpumessage(String cpumessage) {
        this.cpumessage = cpumessage;
    }

    @Basic
    @Column(name = "gpumessage")
    public String getGpumessage() {
        return gpumessage;
    }

    public void setGpumessage(String gpumessage) {
        this.gpumessage = gpumessage;
    }

    @Basic
    @Column(name = "romcapacityid")
    public byte getRomcapacityid() {
        return romcapacityid;
    }

    public void setRomcapacityid(byte romcapacityid) {
        this.romcapacityid = romcapacityid;
    }

    @Basic
    @Column(name = "ram")
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @Basic
    @Column(name = "pixelnumberofblack")
    public String getPixelnumberofblack() {
        return pixelnumberofblack;
    }

    public void setPixelnumberofblack(String pixelnumberofblack) {
        this.pixelnumberofblack = pixelnumberofblack;
    }

    @Basic
    @Column(name = "pixelnumberoffront")
    public String getPixelnumberoffront() {
        return pixelnumberoffront;
    }

    public void setPixelnumberoffront(String pixelnumberoffront) {
        this.pixelnumberoffront = pixelnumberoffront;
    }

    @Basic
    @Column(name = "aperture")
    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    @Basic
    @Column(name = "function")
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Basic
    @Column(name = "others")
    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Basic
    @Column(name = "packing")
    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return id == goods.id &&
                goodsid == goods.goodsid &&
                brandid == goods.brandid &&
                Double.compare(goods.price, price) == 0 &&
                colorid == goods.colorid &&
                Double.compare(goods.weight, weight) == 0 &&
                batterycapacity == goods.batterycapacity &&
                Double.compare(goods.screensize, screensize) == 0 &&
                romcapacityid == goods.romcapacityid &&
                Objects.equals(title, goods.title) &&
                Objects.equals(model, goods.model) &&
                Objects.equals(mainpic, goods.mainpic) &&
                Objects.equals(timetomarket, goods.timetomarket) &&
                Objects.equals(networkmode, goods.networkmode) &&
                Objects.equals(os, goods.os) &&
                Objects.equals(size, goods.size) &&
                Objects.equals(material, goods.material) &&
                Objects.equals(resolutionratio, goods.resolutionratio) &&
                Objects.equals(ppi, goods.ppi) &&
                Objects.equals(cpumessage, goods.cpumessage) &&
                Objects.equals(gpumessage, goods.gpumessage) &&
                Objects.equals(ram, goods.ram) &&
                Objects.equals(pixelnumberofblack, goods.pixelnumberofblack) &&
                Objects.equals(pixelnumberoffront, goods.pixelnumberoffront) &&
                Objects.equals(aperture, goods.aperture) &&
                Objects.equals(function, goods.function) &&
                Objects.equals(others, goods.others) &&
                Objects.equals(packing, goods.packing);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, goodsid, title, brandid, model, price, mainpic, timetomarket, networkmode, os, colorid, size, weight, material, batterycapacity, screensize, resolutionratio, ppi, cpumessage, gpumessage, romcapacityid, ram, pixelnumberofblack, pixelnumberoffront, aperture, function, others, packing);
    }

    @Basic
    @Column(name = "appearanceScore")
    public double getAppearanceScore() {
        return appearanceScore;
    }

    public void setAppearanceScore(double appearanceScore) {
        this.appearanceScore = appearanceScore;
    }

    @Basic
    @Column(name = "performanceScore")
    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    @Basic
    @Column(name = "photoScore")
    public double getPhotoScore() {
        return photoScore;
    }

    public void setPhotoScore(double photoScore) {
        this.photoScore = photoScore;
    }

    @Basic
    @Column(name = "userScore")
    public double getUserScore() {
        return userScore;
    }

    public void setUserScore(double userScore) {
        this.userScore = userScore;
    }
}
