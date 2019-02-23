package org.ssh.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssh.product.dao.GoodsDao;
import org.ssh.product.model.*;
import org.ssh.product.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> getGoodslist(Byte searchid) {

       return goodsDao.getGoodslist(searchid);
    }

    @Override
    public List<Goods> getGoodslist(String key) {

        return goodsDao.getGoodslist(key);
    }

    @Override
    public List<Brand> listBrand() {
        return goodsDao.listBrand();
    }

    @Override
    public Goods findGoods(int goodsid) {
        return goodsDao.findGoods(goodsid);
    }

    @Override
    public Phonecolor getColor(byte colorid) {
        return goodsDao.getColor(colorid);
    }

    @Override
    public Romcapacity getRom(byte romcapacityid) {
        return goodsDao.getRom(romcapacityid);
    }

    @Override
    public Brand listBrandbyid(byte brandid) {
        return goodsDao.listBrandbyid(brandid);
    }

    @Override
    public List<Goods> getGoodslist() {
        return goodsDao.getGoodslist();
    }

    @Override
    public List<Goods> getGoodslistBybrandname(String brandname) {
        return goodsDao.getGoodslistBybrandname(brandname);
    }

    @Override
    public boolean phoneStoreNumberChange(int ordergoodsid, int phonenumber) {
        return goodsDao.phoneStoreNumberChange(ordergoodsid,phonenumber);
    }

    @Override
    public List<Goods> getGoodslistAlldetail() {
        return goodsDao.getGoodslistAlldetail();
    }

    @Override
    public void addPhoneGoods(Goods goods) {
         goodsDao.addPhoneGoods(goods);
    }

    @Override
    public int getGoodsStroeNumber(int goodsid) {
        return goodsDao.getGoodsStroeNumber(goodsid);
    }

    @Override
    public void addPhoneStoreNumber(int goodsid, int storenumber) {
        goodsDao.addPhoneStoreNumber(goodsid,storenumber);
    }

    @Override
    public void updadaScore(int goodsid,Goods goods) {
        goodsDao.updadaScore(goodsid,goods);
    }

    @Override
    public List<Goods> getGoodslist(String s, String s1) {
        return goodsDao.getGoodslist(s,s1);
    }

    @Override
    public List<Goods> getGoodslistforRom(String s, int s1) {
        return goodsDao.getGoodslistforRom(s,s1);
    }

    @Override
    public List<Goods> getGoodslistforRom(String s, String s1, int a) {
        return goodsDao.getGoodslistforRom(s,s1,a);
    }

    @Override
    public List<Goods> getNewPhonelist() {
        return goodsDao.getNewPhonelist();
    }

    @Override
    public Poster getPoster(int i) {
        return goodsDao.getPoster(i);
    }

    @Override
    public Poster getPosterByID(int idposterTable) {
        return goodsDao.getPosterByID(idposterTable);
    }

    @Override
    public void changePoster(int posterid, int postergoodsid, String picname) {
        goodsDao.changePoster(posterid,postergoodsid,picname);
    }

    @Override
    public List<Goods> getGoodslistforColorandRom(String s, int a) {
        return goodsDao.getGoodslistforColorandRom(s,a);
    }

}
