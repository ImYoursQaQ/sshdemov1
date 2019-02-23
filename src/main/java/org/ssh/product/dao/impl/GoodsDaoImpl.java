package org.ssh.product.dao.impl;

import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.ssh.product.dao.GoodsDao;
import org.ssh.product.model.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao{
    private HibernateTemplate template;
    List<Goods> goodslist = null;
    List<Brand> brandlist = null;

    @Autowired
    public GoodsDaoImpl(SessionFactory sessionFactory) {

        this.template = new HibernateTemplate(sessionFactory);

    }


    @Override
    public List<Goods> getGoodslist(Byte searchbrandid) {
        String hql = "FROM Goods g where g.brandid=?";
        System.out.println(hql);
        System.out.println("22222222222222222");
        goodslist = (List<Goods>)template.find(hql, searchbrandid);
        //System.out.println(goodslist.get(0));
       // System.out.println(goodslist.get(0));
        System.out.println("111111111111111findgoods result:"+goodslist.size());
        return goodslist;
    }


    @Override
    public List<Goods> getGoodslist(String key) {
        String hql = "FROM Goods g where g.title like '%"+key+"%'";
        //String hql = "FROM Goods g where g.title like ?";
        System.out.println(hql);
        System.out.println("22222222222222222search");
        goodslist = (List<Goods>)template.find(hql);
        //System.out.println(goodslist.get(0));
        // System.out.println(goodslist.get(0));
        System.out.println("111111111111111searchgoods result:"+goodslist.size());
        return goodslist;
    }

    @Override
    public List<Brand> listBrand() {
        brandlist = (List<Brand>)template.loadAll(Brand.class);

        return brandlist;
    }

    @Override
    public Goods findGoods(int goodsid) {
        Goods goods =new Goods();
        String hql = "FROM Goods g where g.goodsid=?";
        goodslist = (List<Goods>) template.find(hql,goodsid);
        System.out.println("message of goods :"+goods);
        goods=goodslist.get(0);
        return goods;
    }

    @Override
    public Phonecolor getColor(byte colorid) {
        List<Phonecolor> phonecolorlist;

        String hql = "FROM Phonecolor p where p.colorid=?";
        phonecolorlist= (List<Phonecolor>) template.find(hql,colorid);
        return phonecolorlist.get(0);
    }

    @Override
    public Romcapacity getRom(byte romcapacityid) {
        String hql = "FROM Romcapacity r where r.roMcapacityid=?";
        List<Romcapacity>  romcapacityList;
        romcapacityList = (List<Romcapacity>) template.find(hql,romcapacityid);
        return romcapacityList.get(0);
    }

    @Override
    public Brand listBrandbyid(byte brandid) {
        String hql = "FROM Brand b where b.brandid=?";
        brandlist = (List<Brand>)template.find(hql,brandid);
        return brandlist.get(0);
    }

    @Override
    public List<Goods> getGoodslist() {
        String hql = "SELECT g.title,g.appearanceScore,g.performanceScore,g.photoScore,g.userScore,g.goodsid FROM Goods g";

        //List<RankingGoods> goodsList = (List<RankingGoods>) template.find(hql);
        List<Object[]> list= (List<Object[]>) template.find(hql);
        System.out.println("lalal");
        List<Goods> allGoodslist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Goods goodstemp = new Goods();
            String name = (String)list.get(i)[0];

            goodstemp.setTitle(name);
            goodstemp.setAppearanceScore((double) list.get(i)[1]);
            goodstemp.setPerformanceScore((double) list.get(i)[2]);
            goodstemp.setPhotoScore((double) list.get(i)[3]);
            goodstemp.setUserScore((double) list.get(i)[4]);
            goodstemp.setGoodsid((Integer) list.get(i)[5]);
            allGoodslist.add(goodstemp);
           /* allGoodslist.get(i).setAppearanceScore((double) list.get(i)[1]);
            allGoodslist.get(i).setPerformanceScore((double) list.get(i)[2]);
            allGoodslist.get(i).setPhotoScore((double) list.get(i)[3]);
            allGoodslist.get(i).setUserScore((double) list.get(i)[4]);*/
           // System.out.println(name);

        }

        return allGoodslist;
    }

    @Override
    public List<Goods> getGoodslistBybrandname(String brandname) {
        Brand brand =findBrandByBrandname(brandname);
        byte brandid = brand.getBrandid();
        List<Goods> goodslist= getGoodslist(brandid);
        return goodslist;
    }

    @Override
    public boolean phoneStoreNumberChange(int ordergoodsid, int phonenumber) {
        String hql="FROM Phonestore p where p.goodsid=?";
        List<Phonestore> phonestoreList = (List<Phonestore>) template.find(hql,ordergoodsid);
        Phonestore phonestore1 = phonestoreList.get(0);
        if (phonenumber>phonestore1.getGoodsnumber()){
            return false;
        }
        else{
            System.out.println("库存测试");
            phonestore1.setGoodsnumber(phonestore1.getGoodsnumber()-phonenumber);
            template.save(phonestore1);
            return true;
        }

    }

    @Override
    public List<Goods> getGoodslistAlldetail() {
        String hql = "FROM Goods";
        List<Goods> goodsListalldetail= (List<Goods>) template.find(hql);
        return goodsListalldetail;
    }

    @Override
    public void addPhoneGoods(Goods goods) {
        String hql = "select max(goodsid) from Goods";
        List<Integer> number = (List<Integer>) template.find(hql);
        int goods1 = number.get(0);
        System.out.println("插入测试");


        System.out.println(goods1);
        goods.setGoodsid(goods1+1);
        template.save(goods);
        //同时写入库存信息
        addPhoneStore(goods);

    }

    private void addPhoneStore(Goods goods) {

        Phonestore phonestore1 =new Phonestore();
        phonestore1.setGoodsid(goods.getGoodsid());
        phonestore1.setGoodsnumber(0);
        template.save(phonestore1);
    }

    @Override
    public int getGoodsStroeNumber(int goodsid) {
        String hql = "FROM Phonestore ps where ps.goodsid=?";
        System.out.println("查找库存测试");
        System.out.println(goodsid);
        List<Phonestore> phonestoreList = (List<Phonestore>) template.find(hql,goodsid);
        Phonestore phonestore1 = phonestoreList.get(0);
        return phonestore1.getGoodsnumber();
    }

    @Override
    public void addPhoneStoreNumber(int goodsid, int storenumber) {
        System.out.println("库存增加测试111");
        System.out.println(goodsid+":"+storenumber);
        String hql="FROM Phonestore p where p.goodsid=?";
        List<Phonestore> phonestoreList = (List<Phonestore>) template.find(hql,goodsid);
        Phonestore phonestore1 = phonestoreList.get(0);
        phonestore1.setGoodsnumber(storenumber+phonestore1.getGoodsnumber());
        template.save(phonestore1);
    }

    @Override
    public void updadaScore(int goodsid,Goods goods) {
        Goods phone = findGoods(goodsid);
        phone.setAppearanceScore(goods.getAppearanceScore());
        phone.setPerformanceScore(goods.getPerformanceScore());
        phone.setPhotoScore(goods.getPhotoScore());
        template.save(phone);
    }

    @Override
    public List<Goods> getGoodslist(String s, String s1) {
        String hql = "SELECT pc.colorid FROM Phonecolor pc where pc.colorname like '%"+s1+"%'";
        List<Byte> coloridlist= (List<Byte>) template.find(hql);
        Byte colorid  = 0;
        List<Goods> goodsList = new ArrayList<>();
        if (coloridlist.size()!=0){
            colorid = coloridlist.get(0);
            String hql1 = "FROM Goods g where g.title like '%"+s+"%' and g.colorid=?";
            goodsList= (List<Goods>) template.find(hql1,colorid);
        }

        return goodsList;
    }

    @Override
    public List<Goods> getGoodslistforRom(String s, int rom) {
        String hql="select rc.roMcapacityid FROM Romcapacity rc where rc.rom=?";
        List<Byte> romlist = (List<Byte>) template.find(hql,rom);
        List<Goods> goodsList = new ArrayList<>();
        if (romlist.size()!=0){
            Byte romid=romlist.get(0);
            System.out.println(romid);
            String hql1 = "FROM Goods g where g.title like '%"+s+"%' and g.romcapacityid=?";
            goodsList= (List<Goods>) template.find(hql1,romid);
            return goodsList;
        }
        else return goodsList;
    }

    @Override
    public List<Goods> getGoodslistforRom(String s, String s1, int a) {
        Phonecolor phonecolor = findPhoneColorByColorname(s1);
        Byte coloreid = phonecolor.getColorid();
        Romcapacity romcapacity = findRomByRomsize(a);
        Byte romid = romcapacity.getRoMcapacityid();
        String hql1 = "FROM Goods g where g.title like '%"+s+"%' and g.colorid=?and g.romcapacityid=?";
        List<Goods> goodsList= (List<Goods>) template.find(hql1,coloreid,romid);
        return goodsList;
    }

    @Override
    public List<Goods> getNewPhonelist() {
        String hql = "FROM Goods g order by g.timestamp desc ";
        List<Goods> PhoneListorder = (List<Goods>) template.find(hql);
        System.out.println("总共："+PhoneListorder.size());
        List<Goods> PhoneListordertop = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PhoneListordertop.add(PhoneListorder.get(i));
        }
        System.out.println("选择出："+PhoneListordertop.size());
        return PhoneListordertop;
    }

    @Override
    public Poster getPoster(int i) {
        String hql = "FROM Poster p where p.posterLoc=?";

        List<Poster> posterList = (List<Poster>) template.find(hql,i);
        Poster poster = new Poster();
        if(posterList.size()!=0){
            poster = posterList.get(0);
        }
        return poster;
    }

    @Override
    public Poster getPosterByID(int idposterTable) {
        String hql = "FROM Poster p where p.idposterTable=?";
        List<Poster> posterList = (List<Poster>) template.find(hql,idposterTable);
        Poster poster = new Poster();
        if(posterList.size()!=0){
            poster = posterList.get(0);
        }
        return poster;
    }

    @Override
    public void changePoster(int posterid, int postergoodsid, String picname) {
        Poster poster = getPosterByID(posterid);
        poster.setGoodsid(postergoodsid);
        poster.setPosterPath("/image/"+picname);
        template.save(poster);
    }

    @Override
    public List<Goods> getGoodslistforColorandRom(String s, int a) {
        Phonecolor phonecolor = new Phonecolor();
        Romcapacity romcapacity = new Romcapacity();
        Byte phoneid=0;
        Byte romid = 0;
        phonecolor = findPhoneColorByColorname(s);
        if(phonecolor!=null){
            phoneid = phonecolor.getColorid();
        }
        romcapacity = findRomByRomsize(a);
        List<Goods> goodsList = new ArrayList<>();
        if (romcapacity!=null){
            romid = romcapacity.getRoMcapacityid();
        }

        if(phoneid!=0&&romid!=0) {

            String hql = "FROM Goods g where g.colorid=?and romcapacityid=?";
            goodsList = (List<Goods>) template.find(hql, phoneid, romid);


        }

        return goodsList;
    }

    private Romcapacity findRomByRomsize(int a) {
        String hql="FROM Romcapacity rc where rc.rom=?";
        List<Romcapacity> romlist = (List<Romcapacity>) template.find(hql,a);
        Romcapacity rom=new Romcapacity();
        if (romlist.size()!=0){
            rom=romlist.get(0);
        }

        return rom;
    }

    private Phonecolor findPhoneColorByColorname(String s1) {
        String hql = "FROM Phonecolor pc where pc.colorname like '%"+s1+"%'";
        List<Phonecolor> colorlist= (List<Phonecolor>) template.find(hql);
        Phonecolor phonecolor = new Phonecolor();
        if (colorlist.size()!=0){ phonecolor = colorlist.get(0);
        }

        return phonecolor;
    }


    private Brand findBrandByBrandname(String brandname) {
        String hql ="FROM Brand b where b.brandname=?";
        List<Brand> brandList = new ArrayList<>();
        brandList = (List<Brand>) template.find(hql,brandname);
        System.out.println("brand test:");
        System.out.println(brandname);
        System.out.println(brandList.size());
        return brandList.get(0);
    }
}
