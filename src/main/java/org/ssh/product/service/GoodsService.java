package org.ssh.product.service;

import org.ssh.product.model.*;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodslist(Byte searchid);

    List<Goods> getGoodslist(String keyword);

    List<Brand> listBrand();

    Goods findGoods(int goodsid);

    Phonecolor getColor(byte colorid);

    Romcapacity getRom(byte romcapacityid);

    Brand listBrandbyid(byte brandid);

    List<Goods> getGoodslist();

    List<Goods> getGoodslistBybrandname(String brandname);

    boolean phoneStoreNumberChange(int ordergoodsid, int phonenumber);

    List<Goods> getGoodslistAlldetail();

    void addPhoneGoods(Goods goods);

    int getGoodsStroeNumber(int goodsid);

    void addPhoneStoreNumber(int goodsid, int storenumber);

    void updadaScore(int goodsid,Goods goods);

    List<Goods> getGoodslist(String s, String s1);

    List<Goods> getGoodslistforRom(String s, int s1);

    List<Goods> getGoodslistforRom(String s, String s1, int a);

    List<Goods> getNewPhonelist();

    //找对应位置的
    Poster getPoster(int i);

    Poster getPosterByID(int idposterTable);

    void changePoster(int posterid, int postergoodsid, String picname);

    List<Goods> getGoodslistforColorandRom(String s, int a);
}
